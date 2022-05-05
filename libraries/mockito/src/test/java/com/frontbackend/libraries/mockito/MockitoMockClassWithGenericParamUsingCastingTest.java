package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.frontbackend.libraries.mockito.model.Car;
import com.frontbackend.libraries.mockito.model.Driver;
import com.frontbackend.libraries.mockito.service.FooService;
import org.junit.Test;

public class MockitoMockClassWithGenericParamUsingCastingTest {

    @Test
    public void shouldMockGenericService() {
        @SuppressWarnings("unchecked")
        FooService<Car> mockFoo = (FooService<Car>) mock(FooService.class);
        when(mockFoo.getValue()).thenReturn(new Car(new Driver("Mr Bean")));

        Car value = mockFoo.getValue();

        assertEquals("Welcome Mr Bean!", value.printWelcome());
    }
}
