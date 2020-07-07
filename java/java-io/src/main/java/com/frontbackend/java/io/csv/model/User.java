package com.frontbackend.java.io.csv.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {

    @CSVField(column = CSVColumn.USERNAME)
    private String username;

    @CSVField(column = CSVColumn.IDENTIFIER)
    private String id;

    @CSVField(column = CSVColumn.FIRST_NAME)
    private String firstName;

    @CSVField(column = CSVColumn.LAST_NAME)
    private String lastName;

}
