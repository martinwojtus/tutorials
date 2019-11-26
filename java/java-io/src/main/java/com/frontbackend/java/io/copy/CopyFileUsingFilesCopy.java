package com.frontbackend.java.io.copy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFileUsingFilesCopy {

    public static void main(String[] args) throws IOException {

        File source = new File("/tmp/frontbackend.txt");
        File dest = new File("/tmp/frontbackend.copy.txt");

        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
