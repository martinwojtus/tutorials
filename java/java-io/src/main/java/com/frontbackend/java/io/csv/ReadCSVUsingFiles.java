package com.frontbackend.java.io.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCSVUsingFiles {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        List<List<String>> result = Files.readAllLines(Paths.get("/tmp/username.csv"))
                                         .stream()
                                         .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                                         .collect(Collectors.toList());
        System.out.println(result);
    }
}
