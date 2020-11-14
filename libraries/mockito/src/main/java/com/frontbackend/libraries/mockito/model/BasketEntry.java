package com.frontbackend.libraries.mockito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BasketEntry {

    private final Product product;
    private final double quantity;
}
