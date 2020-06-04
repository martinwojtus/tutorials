package com.frontbackend.java.io.url;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ReadURLUsingScanner {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");

        String content;
        try (Scanner scanner = new Scanner(url.openStream(), "UTF-8")) {
            content = scanner.useDelimiter("\\A")
                             .next();
        }
        System.out.println(content);
    }
}
