package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceRange {

    private int min;
    private int max;
}
