package com.frontbackend.libraries.failsafe;

import static org.mockito.Mockito.when;

import java.net.ConnectException;
import java.time.Duration;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.Timeout;
import net.jodah.failsafe.TimeoutExceededException;

@RunWith(MockitoJUnitRunner.class)
public class TimeoutPolicyTest {

    @Mock
    DatabaseConnection connection = new DatabaseConnection();

    @Test(expected = TimeoutExceededException.class)
    public void testTimeout() throws ConnectException {
        // given
        Timeout<Object> timeout = Timeout.of(Duration.ofSeconds(10));
        timeout.onFailure(e -> log(String.format("Connection attempt timed out%s", e.getFailure())));
        timeout.onSuccess(e -> log("Execution completed on time"));

        // when
        when(connection.connect()).then(invocationOnMock -> {
            Thread.sleep(12000);
            return null;
        });

        Failsafe.with(timeout)
                .run(connection::connect);
    }

    private void log(String log) {
        System.out.printf("%s : %s%n", new Date(), log);
    }
}
