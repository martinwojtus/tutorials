package com.frontbackend.java.io.list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFilesInAlphabeticalOrder {

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get("/tmp"))
             .sorted()
             .forEach(System.out::println);
    }
}
