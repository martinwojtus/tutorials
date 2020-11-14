package com.frontbackend.libraries.mockito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BasketEntry {

    private Product product;
    private double quantity;
}
