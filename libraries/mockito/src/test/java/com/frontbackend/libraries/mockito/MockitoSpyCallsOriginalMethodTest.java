package com.frontbackend.libraries.mockito;

import com.frontbackend.libraries.mockito.service.ThrowingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyCallsOriginalMethodTest {

    public ThrowingService instance = new ThrowingService();

    @Test
    public void thisMethodWillThrowArithmeticException() {
        ThrowingService throwingService = Mockito.spy(instance);
        Mockito.when(throwingService.someNotVoidMethod(ArgumentMatchers.anyInt()))
                .thenReturn(1000);
        throwingService.someNotVoidMethod(0);
    }

    @Test
    public void thisMethodWillNotThrowArithmeticException() {
        ThrowingService throwingService = Mockito.spy(instance);
        Mockito.doReturn(1000)
                .when(throwingService)
                .someNotVoidMethod(0);
        int value = throwingService.someNotVoidMethod(0);
        Assert.assertEquals(1000, value);
    }
}
