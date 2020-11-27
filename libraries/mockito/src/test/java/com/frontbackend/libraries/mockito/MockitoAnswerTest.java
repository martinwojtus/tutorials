package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoAnswerTest {

    interface SomeInterface {
        String doSomething(String param);
    }

    @Mock
    SomeInterface someInterface;

    @Test
    public void testThenAnswer() {
        when(someInterface.doSomething(anyString())).thenAnswer(invocation -> invocation.getArguments()[0]);

        assertEquals("someString", someInterface.doSomething("someString"));
        assertEquals("anotherString", someInterface.doSomething("anotherString"));
    }

    @Test
    public void testThenReturn() {
        Mockito.doAnswer(returnsFirstArg())
               .when(someInterface)
               .doSomething(anyString());

        assertEquals("someString", someInterface.doSomething("someString"));
        assertEquals("anotherString", someInterface.doSomething("anotherString"));
    }

    @Test
    public void testReturnsFirstArg() {
        when(someInterface.doSomething(anyString())).then(returnsFirstArg());
        assertEquals("someString", someInterface.doSomething("someString"));
        assertEquals("anotherString", someInterface.doSomething("anotherString"));
    }
}
