package com.frontbackend.java.io.conversions.fromreader.toinputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class ReaderToInputStreamUsingIOUtils {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        InputStream inputStream = new ByteArrayInputStream(IOUtils.toByteArray(reader, StandardCharsets.UTF_8));
    }
}
