package com.frontbackend.java.io.read;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/tmp/frontbackend.txt");

        StringBuilder fileContent = new StringBuilder();
        int i;
        while ((i = fileReader.read()) != -1) {
            fileContent.append((char) i);
        }

        System.out.println(fileContent.toString());
    }
}
