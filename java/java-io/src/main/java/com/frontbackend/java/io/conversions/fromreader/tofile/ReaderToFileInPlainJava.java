package com.frontbackend.java.io.conversions.fromreader.tofile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderToFileInPlainJava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        File file = new File("/tmp/output.txt");
        FileWriter fileWriter = new FileWriter(file);

        int charVal;
        while ((charVal = reader.read()) != -1) {
            fileWriter.append((char) charVal);
        }

        fileWriter.close();
    }
}
