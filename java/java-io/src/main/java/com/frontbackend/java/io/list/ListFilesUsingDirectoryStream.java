package com.frontbackend.java.io.list;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFilesUsingDirectoryStream {

    public static void main(String[] args) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/tmp"))) {
            stream.forEach(path -> {
                if (!Files.isDirectory(path)) {
                    System.out.println(path.getFileName()
                                           .toString());
                }
            });
        }
    }
}
