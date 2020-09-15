package com.frontbackend.libraries.failsafe;

import java.net.ConnectException;

public class DatabaseConnection {

    private String inst;

    public DatabaseConnection(String inst) {
        this.inst = inst;
    }

    public DatabaseConnection() {
    }

    public DatabaseConnection connect() throws ConnectException {
        // try to connect to the external system
        return this;
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" + "inst='" + inst + '\'' + '}';
    }
}
