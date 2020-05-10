package com.frontbackend.java.io.conversions.toreader.frombytearray;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import com.google.common.io.CharSource;

public class ByteArrayToReaderUsingGuava {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        Reader reader = CharSource.wrap(new String(bytes))
                                  .openStream();
    }
}
