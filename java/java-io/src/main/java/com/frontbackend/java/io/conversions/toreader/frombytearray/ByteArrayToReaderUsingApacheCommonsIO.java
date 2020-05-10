package com.frontbackend.java.io.conversions.toreader.frombytearray;

import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.input.CharSequenceReader;

public class ByteArrayToReaderUsingApacheCommonsIO {

    public static void main(String[] args) {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        Reader reader = new CharSequenceReader(new String(bytes));
    }
}
