package com.frontbackend.java.io.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ReadURLUsingInputStream {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");

        try (InputStream inputStream = url.openStream()) {
            // byte[] bytes = inputStream.readAllBytes(); Java 9
            byte[] bytes = new byte[inputStream.available()];
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }
    }
}
