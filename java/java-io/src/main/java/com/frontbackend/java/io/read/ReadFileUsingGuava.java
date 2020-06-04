package com.frontbackend.java.io.read;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Files;

public class ReadFileUsingGuava {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");

        String fileContent = String.join("", Files.readLines(file, StandardCharsets.UTF_8));
        System.out.println(fileContent);
    }
}
