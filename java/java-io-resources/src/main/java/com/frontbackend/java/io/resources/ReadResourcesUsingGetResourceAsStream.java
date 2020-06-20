package com.frontbackend.java.io.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadResourcesUsingGetResourceAsStream {

    public static void main(String[] args) throws IOException {
        ReadResourcesUsingGetResourceAsStream obj = new ReadResourcesUsingGetResourceAsStream();

        StringBuilder out = new StringBuilder();
        InputStream inputStream = obj.getClass()
                                     .getClassLoader()
                                     .getResourceAsStream("example.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
        }

        System.out.println(out.toString());
    }
}
