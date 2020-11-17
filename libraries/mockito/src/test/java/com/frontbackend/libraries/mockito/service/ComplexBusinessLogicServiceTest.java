package com.frontbackend.libraries.mockito.service;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComplexBusinessLogicServiceTest {

    @Mock
    private SimpleMailService simpleMailService;

    @Mock
    private SimpleMultiplicationService simpleMultiplicationService;

    @Mock
    private SimpleSummingService simpleSummingService;

    @Captor
    private ArgumentCaptor<String> emailBodyArgCaptor;

    @Captor
    private ArgumentCaptor<Double> sumACaptor;

    @Captor
    private ArgumentCaptor<Double> sumBCaptor;

    @Captor
    private ArgumentCaptor<Double> mulACaptor;

    @Captor
    private ArgumentCaptor<Double> mulBCaptor;

    @InjectMocks
    private ComplexBusinessLogicService complexBusinessLogicService;

    @Test
    public void testComplexBusinessLogic() {
        // Given
        double a = 10;
        double b = 20;

        when(simpleMailService.sendEmail(anyString())).thenCallRealMethod();
        when(simpleMultiplicationService.multiplication(anyDouble(), anyDouble())).thenCallRealMethod();
        when(simpleSummingService.sum(anyDouble(), anyDouble())).thenCallRealMethod();

        // When
        complexBusinessLogicService.businessLogic(a, b);

        // Then
        verify(simpleSummingService).sum(sumACaptor.capture(), sumBCaptor.capture());
        Assert.assertEquals(Double.valueOf(a * 1000 + 90), sumACaptor.getValue());
        Assert.assertEquals(Double.valueOf(b * 800 + 100), sumBCaptor.getValue());

        verify(simpleMultiplicationService).multiplication(mulACaptor.capture(), mulBCaptor.capture());
        Assert.assertEquals(Double.valueOf(((a * 1000 + 90) + (b * 800 + 100) + 80)), mulACaptor.getValue());
        Assert.assertEquals(Double.valueOf(10), mulBCaptor.getValue());

        verify(simpleMailService).sendEmail(emailBodyArgCaptor.capture());
        Assert.assertEquals(String.format("This is calculated value: %s", ((a * 1000 + 90) + (b * 800 + 100) + 80) * 10),
                emailBodyArgCaptor.getValue());
    }
}
