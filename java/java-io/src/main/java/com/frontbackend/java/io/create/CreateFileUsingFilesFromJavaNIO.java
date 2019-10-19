package com.frontbackend.java.io.create;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileUsingFilesFromJavaNIO {

    public static void main(String[] args) throws IOException {

        Path newFilePath = Paths.get("/tmp/file2.txt");
        Files.createFile(newFilePath);
    }
}
