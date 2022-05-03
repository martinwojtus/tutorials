package com.frontbackend.libraries.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.frontbackend.libraries.mockito.model.Basket;
import com.frontbackend.libraries.mockito.model.Product;
import com.frontbackend.libraries.mockito.service.BasketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MockitoMultipleCallsTest {

    @Spy
    private Basket basket;

    @Mock
    private Product banana;

    @InjectMocks
    private BasketService basketService;

    @Test
    public void shouldCountTotalPriceCorrectly_approach1() {
        // Given
        when(banana.getPrice()).thenReturn(2.00)
                .thenReturn(3.00)
                .thenReturn(4.00);

        // When
        basketService.addProductToBasket(banana, 1); // price = 1 * 2.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 3.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 4.00

        double totalAmount = basketService.getTotalAmount();

        // Then
        assertEquals("Total price should be 9", 9.0, totalAmount, 0);
        verify(basket, times(4)).getEntries(); // adding 3 products + counting total price
    }

    @Test
    public void shouldCountTotalPriceCorrectly_approach2() {
        // Given
        when(banana.getPrice()).thenAnswer(new Answer<Double>() {
            private int count = 0;

            public Double answer(InvocationOnMock invocation) {
                count++;
                switch (count) {
                    case 1:
                        return 2.00;
                    case 2:
                        return 3.00;
                    case 3:
                        return 4.00;
                    default:
                        return 0.00;
                }
            }
        });

        // When
        basketService.addProductToBasket(banana, 1); // price = 1 * 2.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 3.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 4.00

        double totalAmount = basketService.getTotalAmount();

        // Then
        assertEquals("Total price should be 9", 9.0, totalAmount, 0);
        verify(basket, times(4)).getEntries(); // adding 3 products + counting total price
    }

    @Test
    public void shouldCountTotalPriceCorrectly_approach3() {
        // Given
        doAnswer(new Answer<Double>() {
            private int count = 0;

            public Double answer(InvocationOnMock invocation) {
                count++;
                switch (count) {
                    case 1:
                        return 2.00;
                    case 2:
                        return 3.00;
                    case 3:
                        return 4.00;
                    default:
                        return 0.00;
                }
            }
        }).when(banana)
                .getPrice();

        // When
        basketService.addProductToBasket(banana, 1); // price = 1 * 2.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 3.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 4.00

        double totalAmount = basketService.getTotalAmount();

        // Then
        assertEquals("Total price should be 9", 9.0, totalAmount, 0);
        verify(basket, times(4)).getEntries(); // adding 3 products + counting total price
    }

    @Test
    public void shouldCountTotalPriceCorrectly_approach4() {
        // Given
        doReturn(2.00).doReturn(3.00)
                .doReturn(4.00)
                .when(banana)
                .getPrice();

        // When
        basketService.addProductToBasket(banana, 1); // price = 1 * 2.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 3.00
        basketService.addProductToBasket(banana, 1); // price = 1 * 4.00

        double totalAmount = basketService.getTotalAmount();

        // Then
        assertEquals("Total price should be 9", 9.0, totalAmount, 0);
        verify(basket, times(4)).getEntries(); // adding 3 products + counting total price
    }
}
