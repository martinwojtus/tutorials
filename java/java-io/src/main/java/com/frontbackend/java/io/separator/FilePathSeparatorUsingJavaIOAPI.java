package com.frontbackend.java.io.separator;

import java.io.File;

public class FilePathSeparatorUsingJavaIOAPI {

    public static void main(String[] args) {
        String pathSeparator = File.separator;

        System.out.println(pathSeparator); // Unix / , Windows \
    }
}
