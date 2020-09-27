package com.frontbackend.java.io.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ConvertFileToPath {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/test.txt");
        Path path = file.toPath();

        System.out.println(path.toString());
    }
}
