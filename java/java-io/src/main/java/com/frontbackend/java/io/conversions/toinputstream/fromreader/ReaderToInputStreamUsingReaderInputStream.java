package com.frontbackend.java.io.conversions.toinputstream.fromreader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.input.ReaderInputStream;

public class ReaderToInputStreamUsingReaderInputStream {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");
        InputStream inputStream = new ReaderInputStream(reader, StandardCharsets.UTF_8);
    }
}
