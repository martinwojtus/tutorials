package com.frontbackend.java.io.read;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFileUsingFiles {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");
        String join = String.join("", Files.readAllLines(file.toPath()));

        System.out.println(join);
    }
}
