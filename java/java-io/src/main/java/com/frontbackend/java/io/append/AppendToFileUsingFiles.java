package com.frontbackend.java.io.append;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppendToFileUsingFiles {

    public static void main(String[] args) throws IOException {
        final String textToAppend = "FrontBackend";

        Path path = Paths.get("/tmp/test4.txt");

        Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);  // activate append mode
    }
}
