package com.frontbackend.libraries.mockito.service;

import com.frontbackend.libraries.mockito.model.Basket;
import com.frontbackend.libraries.mockito.model.BasketEntry;
import com.frontbackend.libraries.mockito.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasketService {

    private final Basket basket;

    public void addProductToBasket(Product product, double quantity) {
        BasketEntry basketEntry = new BasketEntry(product, quantity);
        basket.getEntries()
              .add(basketEntry);
    }

    public double getTotalAmount() {
        return basket.getEntries()
                     .stream()
                     .mapToDouble(this::getBasketEntryPrice)
                     .sum();
    }

    private double getBasketEntryPrice(BasketEntry basketEntry) {
        return basketEntry.getProduct()
                          .getPrice()
                * basketEntry.getQuantity();
    }
}
