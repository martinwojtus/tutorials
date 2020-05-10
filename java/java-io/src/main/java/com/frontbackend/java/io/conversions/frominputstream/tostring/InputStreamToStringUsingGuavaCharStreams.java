package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.common.io.CharStreams;

public class InputStreamToStringUsingGuavaCharStreams {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        final String text;

        try (final Reader reader = new InputStreamReader(inputStream)) {
            text = CharStreams.toString(reader);
        }

        System.out.println(text);
    }
}
