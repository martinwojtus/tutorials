package com.frontbackend.libraries.mockito;

import com.frontbackend.libraries.mockito.model.Car;
import com.frontbackend.libraries.mockito.model.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCarDriverTest {

    @Mock
    private Driver driver;

    @InjectMocks
    private Car car;

    @Test
    public void printWelcomeTest() {
        Mockito.when(driver.getName()).thenReturn("John");

        String msg = car.printWelcome();

        assertEquals("Welcome John!", msg);
    }
}
