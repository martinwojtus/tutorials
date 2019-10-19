package com.frontbackend.java.io.write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFileUsingFileChannel {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/temp/test5.txt");
        Files.write(path, "FrontBackend.com".getBytes());
    }
}
