package com.frontbackend.java.io.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingBufferedReader {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder fileContent = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null) {
            fileContent.append(st);
        }

        System.out.println(fileContent.toString());
    }
}
