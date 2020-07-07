package com.frontbackend.java.io.csv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CSVColumn {

    USERNAME("Username"),
    IDENTIFIER("Identifier"),
    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    DEFAULT("");

    @Getter
    private final String column;
}
