package com.frontbackend.java.io.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVUsingOpenCSV {

    public static void main(String[] args) throws IOException {
        List<List<String>> result = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("/tmp/username.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                result.add(Arrays.asList(values));
            }
        }

        System.out.println(result);
    }
}
