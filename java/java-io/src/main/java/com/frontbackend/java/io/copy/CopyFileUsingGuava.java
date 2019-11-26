package com.frontbackend.java.io.copy;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class CopyFileUsingGuava {

    public static void main(String[] args) throws IOException {

        File source = new File("/tmp/frontbackend.txt");
        File dest = new File("/tmp/frontbackend.copy.txt");

        Files.copy(source, dest);
    }
}
