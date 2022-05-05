package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.frontbackend.libraries.mockito.model.Car;
import com.frontbackend.libraries.mockito.model.Driver;
import com.frontbackend.libraries.mockito.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoMockClassWithGenericParamUsingAnnotationTest {

    @Mock
    public FooService<Car> mockFoo;

    @Test
    public void testFoo() {
        when(mockFoo.getValue()).thenReturn(new Car(new Driver("Mr Bean")));

        Car value = mockFoo.getValue();

        assertEquals("Welcome Mr Bean!", value.printWelcome());
    }
}
