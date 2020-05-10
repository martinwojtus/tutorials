package com.frontbackend.java.io.conversions.fromreader.tostring;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderToStringUsingReadingCharacters {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        int valChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((valChar = reader.read()) != -1) {
            stringBuilder.append((char) valChar);
        }

        String str = stringBuilder.toString();
    }
}
