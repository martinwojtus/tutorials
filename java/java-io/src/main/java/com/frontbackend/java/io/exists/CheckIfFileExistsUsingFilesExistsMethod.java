package com.frontbackend.java.io.exists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckIfFileExistsUsingFilesExistsMethod {

    public static void main(String[] args) throws IOException {
        final Path path = Files.createTempFile("frontbackend", ".txt");

        System.out.println("File exists : " + Files.exists(path)); // true
        System.out.println("File not exists: " + Files.notExists(path)); // false
    }
}
