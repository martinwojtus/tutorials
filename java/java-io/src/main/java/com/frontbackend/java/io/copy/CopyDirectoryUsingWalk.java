package com.frontbackend.java.io.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyDirectoryUsingWalk {

    public static void main(String[] args) throws IOException {
        final Path fromPath = Paths.get("/tmp/from");

        Files.walk(fromPath)
             .forEach(source -> copySourceToDest(fromPath, source));
    }

    private static void copySourceToDest(Path fromPath, Path source) {
        Path destination = Paths.get("/tmp/to", source.toString()
                                                      .substring(fromPath.toString()
                                                                         .length()));
        try {
            Files.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
