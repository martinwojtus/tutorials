package com.frontbackend.java.io.list;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ListFilesUsingFile {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp");

        Arrays.stream(file.listFiles())
              .forEach(System.out::println);

        Arrays.stream(file.listFiles(file1 -> file1.getName()
                                                   .endsWith(".txt")))
              .forEach(System.out::println);
    }
}
