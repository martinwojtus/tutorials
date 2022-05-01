package com.frontbackend.libraries.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.frontbackend.libraries.mockito.service.ThrowingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoThrowsTest {

    @Test(expected = IllegalArgumentException.class)
    public void forVoidMethod_whenArgumentIsZero_shouldThrowIllegalArgumentException() {
        ThrowingService service = Mockito.mock(ThrowingService.class);
        doThrow(new IllegalArgumentException()).when(service)
                .someVoidMethod(0);
        service.someVoidMethod(0);
    }

    @Test(expected = ArithmeticException.class)
    public void forVoidMethod_whenArgumentIsZeroAndCallingRealMethod_shouldThrowArithmeticException() {
        ThrowingService service = Mockito.mock(ThrowingService.class);
        doCallRealMethod().when(service)
                .someVoidMethod(anyInt());
        service.someVoidMethod(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forNotVoidMethod_whenArgumentIsZero_shouldThrowIllegalArgumentException() {
        ThrowingService service = Mockito.mock(ThrowingService.class);
        when(service.someNotVoidMethod(0)).thenThrow(new IllegalArgumentException());
        service.someNotVoidMethod(0);
    }

    @Test(expected = ArithmeticException.class)
    public void forNotVoidMethod_whenArgumentIsZeroAndCallingRealMethod_shouldThrowArithmeticException() {
        ThrowingService service = Mockito.mock(ThrowingService.class);
        when(service.someNotVoidMethod(anyInt())).thenCallRealMethod();
        service.someNotVoidMethod(0);
    }
}
