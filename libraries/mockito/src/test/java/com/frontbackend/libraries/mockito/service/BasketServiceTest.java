package com.frontbackend.libraries.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.frontbackend.libraries.mockito.model.Basket;
import com.frontbackend.libraries.mockito.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    @Spy
    private Basket basket;

    @Mock
    private Product banana;

    @InjectMocks
    private BasketService basketService;

    @Test
    public void shouldCountTotalPriceCorrectly() {
        // Given
        Product milk = new Product("Milk", 10.00);
        when(banana.getPrice()).thenReturn(2.00);

        // When
        basketService.addProductToBasket(banana, 2.5);
        basketService.addProductToBasket(milk, 1.5);
        double totalAmount = basketService.getTotalAmount();

        // Then
        assertEquals("Total price should be 20.0", 20.0, totalAmount, 0);
        verify(basket, times(3)).getEntries(); // adding 2 products + counting total price
        verify(banana, never()).getName(); // method getName() was never called
    }
}
