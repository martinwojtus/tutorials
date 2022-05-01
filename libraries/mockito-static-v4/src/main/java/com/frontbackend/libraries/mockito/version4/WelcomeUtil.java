package com.frontbackend.libraries.mockito.version4;

public final class WelcomeUtil {

    public static String generateWelcome(String name) {
        return String.format("Welcome %s", name);
    }

    private WelcomeUtil() {
    }
}
