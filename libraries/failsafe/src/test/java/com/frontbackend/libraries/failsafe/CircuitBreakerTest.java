package com.frontbackend.libraries.failsafe;

import static org.mockito.Mockito.when;

import java.net.ConnectException;
import java.time.Duration;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.CircuitBreakerOpenException;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

@RunWith(MockitoJUnitRunner.class)
public class CircuitBreakerTest {

    @Mock
    DatabaseConnection connection = new DatabaseConnection();

    @Test(expected = CircuitBreakerOpenException.class)
    public void testCircuitBreakerPolicy() throws ConnectException {
        // given
        RetryPolicy<Object> retryPolicy = new RetryPolicy<>().handle(ConnectException.class)
                                                             .withDelay(Duration.ofSeconds(1))
                                                             .withMaxRetries(5)
                                                             .onFailedAttempt(
                                                                     e -> log(String.format("Connection attempt failed %s", e.getLastFailure())))
                                                             .onRetry(e -> log(String.format("Failure #%d. Retrying.", e.getAttemptCount())))
                                                             .onRetriesExceeded(e -> log("Failed to connect. Max retries exceeded."))
                                                             .onAbort(e -> log(String.format("Connection aborted due to %s.", e.getFailure())));

        CircuitBreaker<Object> breaker = new CircuitBreaker<>().handle(ConnectException.class)
                                                               .withFailureThreshold(2)
                                                               .withSuccessThreshold(1)
                                                               .withDelay(Duration.ofMinutes(1))
                                                               .onOpen(() -> log("The circuit breaker was opened"))
                                                               .onClose(() -> log("The circuit breaker was closed"))
                                                               .onHalfOpen(() -> log("The circuit breaker was half-opened"));
        // when
        when(connection.connect()).thenThrow(ConnectException.class)
                                  .thenThrow(ConnectException.class)
                                  .thenReturn(connection);

        Failsafe.with(retryPolicy, breaker)
                .run(connection::connect);

        // then
    }

    private void log(String log) {
        System.out.printf("%s : %s%n", new Date(), log);
    }
}
