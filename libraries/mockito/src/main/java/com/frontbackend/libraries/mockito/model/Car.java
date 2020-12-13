package com.frontbackend.libraries.mockito.model;

public class Car {

    private final Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    public String printWelcome() {
        return String.format("Welcome %s!", driver.getName());
    }
}
