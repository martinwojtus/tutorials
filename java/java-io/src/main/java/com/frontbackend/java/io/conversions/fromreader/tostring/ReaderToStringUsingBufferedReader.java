package com.frontbackend.java.io.conversions.fromreader.tostring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderToStringUsingBufferedReader {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String str = stringBuilder.toString();
    }
}
