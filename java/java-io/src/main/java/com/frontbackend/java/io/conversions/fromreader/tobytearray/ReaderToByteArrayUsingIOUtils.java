package com.frontbackend.java.io.conversions.fromreader.tobytearray;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class ReaderToByteArrayUsingIOUtils {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        byte[] bytes = IOUtils.toByteArray(reader, StandardCharsets.UTF_8);
    }
}
