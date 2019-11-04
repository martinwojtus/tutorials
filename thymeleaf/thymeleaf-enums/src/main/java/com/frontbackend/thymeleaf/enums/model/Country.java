package com.frontbackend.thymeleaf.enums.model;

import lombok.Getter;

public enum Country {

    SPAIN("Spain"),
    USA("United States of America"),
    UK("United Kingdom");

    @Getter
    private String displayName;

    Country(String displayName) {
        this.displayName = displayName;
    }
}
