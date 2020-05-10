package com.frontbackend.java.io.conversions.toreader.frombytearray;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ByteArrayToReaderUsingInputStreamReader {

    public static void main(String[] args) {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        Reader targetReader = new InputStreamReader(new ByteArrayInputStream(bytes));
    }
}
