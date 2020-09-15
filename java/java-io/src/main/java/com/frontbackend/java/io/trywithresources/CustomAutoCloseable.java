package com.frontbackend.java.io.trywithresources;

public class CustomAutoCloseable implements AutoCloseable {

    public static void main(String[] args) {
        try (CustomAutoCloseable autoCloseable = new CustomAutoCloseable()) {
            autoCloseable.start();
        }
    }

    public void start() {
        System.out.println("Start...");
    }

    @Override
    public void close() {
        System.out.println("Closing resource...");
    }
}
