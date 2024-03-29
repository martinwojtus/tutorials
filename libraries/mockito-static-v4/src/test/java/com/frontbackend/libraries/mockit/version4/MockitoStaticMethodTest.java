package com.frontbackend.libraries.mockit.version4;

import static org.junit.Assert.assertEquals;

import com.frontbackend.libraries.mockito.version4.WelcomeUtil;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MockitoStaticMethodTest {

    @Test
    public void testMockStaticMethods() {
        assertEquals("Welcome John", WelcomeUtil.generateWelcome("John"));

        try (MockedStatic<WelcomeUtil> theMock = Mockito.mockStatic(WelcomeUtil.class)) {
            theMock.when(() -> WelcomeUtil.generateWelcome("John"))
                   .thenReturn("Guten Tag John");

            assertEquals("Guten Tag John", WelcomeUtil.generateWelcome("John"));
        }

        assertEquals("Welcome John", WelcomeUtil.generateWelcome("John"));
    }
}
