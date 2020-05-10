package com.frontbackend.java.io.conversions.frominputstream.toreader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class InputStreamToReaderUsingInputStreamReader {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("frontbackend.com".getBytes());

        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
    }
}
