package com.frontbackend.java.io.conversions.toinputstream.fromreader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class ReaderToInputStreamUsingPlainJava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        char[] charBuffer = new char[1024];
        StringBuilder builder = new StringBuilder();

        int read;
        while ((read = reader.read(charBuffer, 0, charBuffer.length)) != -1) {
            builder.append(charBuffer, 0, read);
        }

        InputStream inputStream = new ByteArrayInputStream(builder.toString()
                                                                  .getBytes(StandardCharsets.UTF_8));
    }
}
