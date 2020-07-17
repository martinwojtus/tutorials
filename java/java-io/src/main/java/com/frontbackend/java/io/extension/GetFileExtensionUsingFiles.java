package com.frontbackend.java.io.extension;

import java.io.File;

import com.google.common.io.Files;

public class GetFileExtensionUsingFiles {

    public static void main(String[] args) {

        File source = new File("/tmp/test.txt");
        String filename = source.getName();

        System.out.println(Files.getFileExtension(filename));
    }
}
