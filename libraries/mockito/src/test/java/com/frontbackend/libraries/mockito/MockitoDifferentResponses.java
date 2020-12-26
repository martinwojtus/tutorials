package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoDifferentResponses {

    interface SomeMock {
        String someMethod();
    }

    static class SomeSpy {
        String spyMethod() {
            return "spy";
        }
    }

    @Mock
    private SomeMock someMock;

    @Spy
    private SomeSpy someSpy = new SomeSpy();

    @Test
    public void testMockWithDifferentResponses() {
        when(someMock.someMethod()).thenReturn("First Value", "Second Value");

        String firstResponse = someMock.someMethod();
        String secondResponse = someMock.someMethod();

        assertEquals("First Value", firstResponse);
        assertEquals("Second Value", secondResponse);
    }

    @Test
    public void testSpyMethodWithDifferentResponses() {
        doReturn("First Value").doReturn("Second Value")
                               .when(someSpy)
                               .spyMethod();

        String firstResponse = someSpy.spyMethod();
        String secondResponse = someSpy.spyMethod();

        assertEquals("First Value", firstResponse);
        assertEquals("Second Value", secondResponse);
    }
}
