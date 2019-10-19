package com.frontbackend.java.io.create;

import java.io.File;
import java.io.IOException;

public class CreateFileUsingFile {

    public static void main(String[] args) throws IOException {

        File file = new File("/tmp/file1.txt");

        // Create the file
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
    }
}
