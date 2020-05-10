package com.frontbackend.java.io.conversions.toreader.fromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileToReaderUsingFileReader {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/tmp/input.txt");

        Reader reader = new FileReader(file);
    }
}
