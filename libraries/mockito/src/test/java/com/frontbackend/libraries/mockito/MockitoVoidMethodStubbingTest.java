package com.frontbackend.libraries.mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVoidMethodStubbingTest {

    @Mock
    private SimpleInterface simpleInterface;

    interface SimpleInterface {
        void doSomething();
    }

    @Test(expected = RuntimeException.class)
    public void testStubbingVoidMethod() {
        doThrow(new RuntimeException("Something is not right")).when(simpleInterface)
                                                               .doSomething();
        simpleInterface.doSomething();
    }

    @Test
    public void testStubbingVoidMethodRetry() {
        // Given
        doThrow(new RuntimeException("Something is not right")).doNothing()
                                                               .when(simpleInterface)
                                                               .doSomething();
        // When
        try {
            simpleInterface.doSomething();
        } catch (RuntimeException e) {
            // first call should throw a RuntimeException
        }
        simpleInterface.doSomething();

        // Then
        verify(simpleInterface, times(2)).doSomething();
    }
}
