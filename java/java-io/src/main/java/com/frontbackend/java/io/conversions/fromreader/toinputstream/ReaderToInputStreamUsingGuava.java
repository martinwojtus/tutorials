package com.frontbackend.java.io.conversions.fromreader.toinputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import com.google.common.io.CharStreams;

public class ReaderToInputStreamUsingGuava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        InputStream inputStream = new ByteArrayInputStream(CharStreams.toString(reader)
                                                                      .getBytes(StandardCharsets.UTF_8));
    }
}
