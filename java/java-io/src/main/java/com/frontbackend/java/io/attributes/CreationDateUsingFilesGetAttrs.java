package com.frontbackend.java.io.attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;

public class CreationDateUsingFilesGetAttrs {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");

        FileTime creationTime = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
        System.out.printf("The file creation date and time is: %s%n", creationTime);
    }
}
