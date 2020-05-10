package com.frontbackend.java.io.conversions.fromreader.tobytearray;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class ReaderToByteArrayInPlainJava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        char[] buffer = new char[4096];
        StringBuilder builder = new StringBuilder();
        int numChars;

        while ((numChars = reader.read(buffer)) >= 0) {
            builder.append(buffer, 0, numChars);
        }

        byte[] bytes = builder.toString()
                              .getBytes(StandardCharsets.UTF_8);

    }
}
