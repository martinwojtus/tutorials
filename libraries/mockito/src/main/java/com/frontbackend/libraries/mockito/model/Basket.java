package com.frontbackend.libraries.mockito.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Basket {

    private List<BasketEntry> entries = new ArrayList<>();
}
