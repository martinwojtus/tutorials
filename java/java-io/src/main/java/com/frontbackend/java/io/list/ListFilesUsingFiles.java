package com.frontbackend.java.io.list;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListFilesUsingFiles {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get("/tmp"), 1)) {
            stream.filter(file -> !Files.isDirectory(file))
                  .map(Path::getFileName)
                  .map(Path::toString)
                  .forEach(System.out::println);
        }
    }
}
