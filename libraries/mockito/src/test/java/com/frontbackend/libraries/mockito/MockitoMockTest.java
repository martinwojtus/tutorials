package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoMockTest {

    @Mock
    private List<String> mock;

    @Test
    public void shouldAddItemsToList() {
        mock.add("one");
        mock.add("two");

        Mockito.verify(mock, times(2)).add(anyString());
        Mockito.verify(mock).add("one");
        Mockito.verify(mock).add("two");
    }
}
