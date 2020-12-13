package com.frontbackend.java.io.separator;

import java.nio.file.FileSystems;

public class FilePathSeparatorUsingJavaNIO {

    public static void main(String[] args) {
        String pathSeparator = FileSystems.getDefault()
                                          .getSeparator();

        System.out.println(pathSeparator); // in Unix / , in Windows \
    }
}
