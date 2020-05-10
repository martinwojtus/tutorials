package com.frontbackend.java.io.conversions.fromreader.toinputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class ReaderToInputStreamInPlainJava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        char[] buffer = new char[4096];
        StringBuilder builder = new StringBuilder();
        int numChars;

        while ((numChars = reader.read(buffer)) >= 0) {
            builder.append(buffer, 0, numChars);
        }

        InputStream inputStream = new ByteArrayInputStream(builder.toString()
                                                                  .getBytes(StandardCharsets.UTF_8));
    }
}
