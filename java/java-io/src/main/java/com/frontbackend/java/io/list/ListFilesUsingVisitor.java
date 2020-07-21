package com.frontbackend.java.io.list;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ListFilesUsingVisitor {

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("/tmp"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (!Files.isDirectory(file)) {
                    System.out.println(file.getFileName()
                                           .toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
