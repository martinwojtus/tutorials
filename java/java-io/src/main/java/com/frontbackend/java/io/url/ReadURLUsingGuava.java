package com.frontbackend.java.io.url;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Resources;

public class ReadURLUsingGuava {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");

        String str = Resources.toString(url, StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
