package com.frontbackend.java.io.conversions.fromreader.tostring;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderToStringUsingStringBuilder {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        char[] buffer = new char[4096];
        StringBuilder builder = new StringBuilder();
        int numChars;

        while ((numChars = reader.read(buffer)) >= 0) {
            builder.append(buffer, 0, numChars);
        }

        String str = builder.toString();
    }
}
