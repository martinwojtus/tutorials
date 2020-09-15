package com.frontbackend.libraries.failsafe;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.ConnectException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.Fallback;

@RunWith(MockitoJUnitRunner.class)
public class FallbackPolicyTest {

    @Mock
    DatabaseConnection connection = new DatabaseConnection();

    @Test
    public void testFallback() throws ConnectException {
        // given
        DatabaseConnection result = null;
        DatabaseConnection other = new DatabaseConnection("other");
        Fallback<Object> fallback = Fallback.of(other);
        fallback.onFailedAttempt(e -> log(String.format("Connection failed%s", e.getLastFailure())));
        fallback.onFailure(e -> log(String.format("Failed to connect to backup%s", e.getFailure())));
        fallback.onSuccess(e -> log(String.format("Connection established %s", e.getResult())));

        // when
        when(connection.connect()).thenThrow(ConnectException.class);

        Failsafe.with(fallback)
                .run(connection::connect);

        // then
        verify(connection, Mockito.times(1)).connect();
    }

    private void log(String log) {
        System.out.printf("%s : %s%n", new Date(), log);
    }
}
