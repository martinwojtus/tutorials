package com.frontbackend.libraries.mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MockitoWhenThenVsThenAnswerTest {

    interface SomeDummyInterface {
        int getStringLength(String str);
    }

    @Mock
    SomeDummyInterface someDummyInterface;

    @Test
    public void testWhenThenReturn() {
        int returnValue = 5;

        Mockito.when(someDummyInterface.getStringLength("dummy"))
               .thenReturn(returnValue);
        doReturn(returnValue).when(someDummyInterface)
                             .getStringLength("dummy");
    }

    @Test
    public void testThenAnswer() {
        Answer<Integer> answer = invocation -> {
            String string = (String) invocation.getArguments()[0];
            return string.length() * 2;
        };

        when(someDummyInterface.getStringLength("dummy")).thenAnswer(answer);
        Mockito.doAnswer(answer)
               .when(someDummyInterface)
               .getStringLength("dummy");
    }
}
