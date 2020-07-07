package com.frontbackend.java.io.attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class CreationDateUsingFilesReadAttrs {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");

        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        System.out.printf("The file creation date and time is: %s%n", attributes.creationTime());
    }
}
