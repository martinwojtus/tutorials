package com.frontbackend.libraries.powermock.utils;

public final class WelcomeUtil {

    public static String generateWelcome(String name) {
        return String.format("Welcome %s", name);
    }

    private WelcomeUtil() {
    }
}
