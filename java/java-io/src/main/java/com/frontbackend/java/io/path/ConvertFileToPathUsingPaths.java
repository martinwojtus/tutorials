package com.frontbackend.java.io.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertFileToPathUsingPaths {

    public static void main(String[] args) {
        File file = new File("/tmp/test.txt");
        Path path = Paths.get(file.toURI());

        System.out.println(path.toString());
    }
}
