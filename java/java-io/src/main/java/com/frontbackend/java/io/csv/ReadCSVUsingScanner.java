package com.frontbackend.java.io.csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSVUsingScanner {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        List<List<String>> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("/tmp/username.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                List<String> fields = new ArrayList<>();
                try (Scanner rowScanner = new Scanner(line)) {
                    rowScanner.useDelimiter(COMMA_DELIMITER);
                    while (rowScanner.hasNext()) {
                        fields.add(rowScanner.next());
                    }
                }

                result.add(fields);
            }
        }

        System.out.println(result);
    }
}
