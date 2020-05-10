package com.frontbackend.java.io.conversions.toreader.fromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Files;

public class FileToReaderUsingGuava {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/tmp/input.txt");

        Reader reader = Files.newReader(file, StandardCharsets.UTF_8);
    }
}
