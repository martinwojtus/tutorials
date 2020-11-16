package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

    @Spy
    private final List<String> list = new ArrayList<>();

    @Mock
    private List<String> mockedList;

    @Spy
    private final List<String> spiedList = new ArrayList<>();

    @Test
    public void shouldAddItemsToListSuccessfully() {
        list.add("one");
        list.add("two");

        verify(list, times(2)).add(anyString());

        verify(list).add("one");
        verify(list).add("two");

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void shouldAddItemsToListSuccessfullyUsingMockMethod() {
        List<String> list = Mockito.spy(new ArrayList<>());

        list.add("one");
        list.add("two");

        verify(list, times(2)).add(anyString());

        verify(list).add("one");
        verify(list).add("two");

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void shouldReturnDifferentSizeWhenStubbed() {
        when(list.size()).thenReturn(100);

        list.add("one");
        list.add("two");

        verify(list, times(2)).add(anyString());

        verify(list).add("one");
        verify(list).add("two");

        Assert.assertEquals(100, list.size());
    }

    @Test
    public void testMockedList() {
        mockedList.add("one");
        Mockito.verify(mockedList)
               .add("one");

        Assert.assertEquals(0, mockedList.size());
    }

    @Test
    public void testSpiedList() {
        spiedList.add("one");
        Mockito.verify(spiedList)
               .add("one");

        Assert.assertEquals(1, spiedList.size());
    }
}
