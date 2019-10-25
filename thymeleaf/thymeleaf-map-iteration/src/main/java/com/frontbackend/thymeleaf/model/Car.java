package com.frontbackend.thymeleaf.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Car {

    private String vin;
    private Color color;
    private String model;
    private Date productionDate;
}
