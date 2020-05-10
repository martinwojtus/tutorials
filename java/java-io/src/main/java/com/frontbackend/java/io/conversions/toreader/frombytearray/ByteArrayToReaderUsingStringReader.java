package com.frontbackend.java.io.conversions.toreader.frombytearray;

import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class ByteArrayToReaderUsingStringReader {

    public static void main(String[] args) {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        Reader reader = new StringReader(new String(bytes));
    }
}
