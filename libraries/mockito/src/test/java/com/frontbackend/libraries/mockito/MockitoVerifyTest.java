package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVerifyTest {

    @Mock
    private List<String> list;

    @Test
    public void shouldCallTwoTimes() {
        list.add("one");
        list.add("two");

        verify(list, times(2)).add(anyString());
        verify(list, never()).add("three");
        verify(list, never()).remove(anyInt());
        verify(list, atLeastOnce()).add(anyString());
        verify(list, atMost(2)).add(anyString());
        verify(list, atLeast(2)).add(anyString());
    }
}
