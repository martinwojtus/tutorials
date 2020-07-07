package com.frontbackend.java.io.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCSVUsingBufferedReader {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/username.csv"))) {

            List<List<String>> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                result.add(Arrays.asList(values));
            }

            System.out.println(result);
        }
    }
}
