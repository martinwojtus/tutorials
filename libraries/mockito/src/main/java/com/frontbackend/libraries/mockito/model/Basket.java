package com.frontbackend.libraries.mockito.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Basket {

    private final List<BasketEntry> entries = new ArrayList<>();
}
