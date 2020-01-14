package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Product {

    private String name;
    private String material;
    private String brand;
    private Double price;
}
