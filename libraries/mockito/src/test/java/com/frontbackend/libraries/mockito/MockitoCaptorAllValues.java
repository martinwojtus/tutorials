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

import lombok.AllArgsConstructor;
import lombok.Getter;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCaptorAllValues {

    @AllArgsConstructor
    static class Person {
        @Getter
        private final String name;
    }

    @Mock
    private List<Person> list;

    @Captor
    private ArgumentCaptor<Person> personArgumentCaptor;

    @Test
    public void shouldCaptureListParameters() {
        list.add(new Person("John"));
        list.add(new Person("Alan"));

        verify(list, times(2)).add(personArgumentCaptor.capture());

        List<Person> allValues = personArgumentCaptor.getAllValues();

        Assert.assertEquals("John", allValues.get(0)
                                             .getName());
        Assert.assertEquals("Alan", allValues.get(1)
                                             .getName());
    }
}
