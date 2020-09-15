package com.frontbackend.libraries.failsafe;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.ConnectException;
import java.time.Duration;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

@RunWith(MockitoJUnitRunner.class)
public class RetryPolicyTest {

    @Mock
    DatabaseConnection connection = new DatabaseConnection();

    @Test
    public void testMaxRetries() throws ConnectException {
        // given
        RetryPolicy<Object> retryPolicy = new RetryPolicy<>().handle(ConnectException.class)
                                                             .withDelay(Duration.ofSeconds(1))
                                                             .withMaxRetries(3);

        when(connection.connect()).thenThrow(ConnectException.class)
                                  .thenReturn(connection);

        // when
        Failsafe.with(retryPolicy)
                .run(connection::connect);

        // then
        verify(connection, Mockito.times(2)).connect();
    }

    @Test
    public void testRetryPolicyParameters() throws ConnectException {
        // given
        RetryPolicy<Object> retryPolicy = new RetryPolicy<>().handle(ConnectException.class)
                                                             .withDelay(Duration.ofSeconds(5))
                                                             .withMaxRetries(3)
                                                             .onFailedAttempt(
                                                                     e -> log(String.format("Connection attempt failed %s", e.getLastFailure())))
                                                             .onRetry(e -> log(String.format("Failure #%d. Retrying.", e.getAttemptCount())))
                                                             .onRetriesExceeded(e -> log("Failed to connect. Max retries exceeded."))
                                                             .onAbort(e -> log(String.format("Connection aborted due to %s.", e.getFailure())));

        when(connection.connect()).thenThrow(ConnectException.class)
                                  .thenThrow(ConnectException.class)
                                  .thenThrow(ConnectException.class)
                                  .thenReturn(connection);

        // when
        Failsafe.with(retryPolicy)
                .run(connection::connect);

        // then
        verify(connection, Mockito.times(4)).connect();
    }

    private void log(String log) {
        System.out.printf("%s : %s%n", new Date(), log);
    }
}
