package com.frontbackend.libraries.mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCaptorTest {

    @Mock
    private List<String> list;

    @Captor
    private ArgumentCaptor<String> valueCaptor;

    @Test
    public void shouldCaptureListParameters() {
        list.add("one");
        list.add("two");

        verify(list, times(2)).add(valueCaptor.capture());

        List<String> allValues = valueCaptor.getAllValues();

        Assert.assertTrue(allValues.contains("one"));
        Assert.assertTrue(allValues.contains("two"));

        Assert.assertEquals("two", valueCaptor.getValue());
    }
}
