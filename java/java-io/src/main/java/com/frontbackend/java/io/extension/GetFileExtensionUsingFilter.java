package com.frontbackend.java.io.extension;

import java.io.File;
import java.util.Optional;

public class GetFileExtensionUsingFilter {

    public static void main(String[] args) {

        File source = new File("/tmp/test.txt");
        String filename = source.getName();

        String extension = Optional.of(filename)
                                   .filter(f -> f.contains("."))
                                   .map(f -> f.substring(filename.lastIndexOf(".") + 1))
                                   .orElse("");

        System.out.println(extension);
    }
}
