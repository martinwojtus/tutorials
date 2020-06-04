package com.frontbackend.java.io.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class ReadURLUsingApacheCommonsIO {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");

        try (InputStream in = url.openStream()) {
            String str = IOUtils.toString(in, StandardCharsets.UTF_8);
            System.out.println(str);
        }
    }
}
