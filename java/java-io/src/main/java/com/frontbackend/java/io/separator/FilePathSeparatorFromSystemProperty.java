package com.frontbackend.java.io.separator;

public class FilePathSeparatorFromSystemProperty {

    public static void main(String[] args) {

        String pathSeparator = System.getProperty("file.separator");

        System.out.println(pathSeparator); // in Unix /, in Windows \
    }
}
