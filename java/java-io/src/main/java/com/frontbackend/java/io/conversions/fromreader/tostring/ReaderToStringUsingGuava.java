package com.frontbackend.java.io.conversions.fromreader.tostring;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.google.common.io.CharStreams;

public class ReaderToStringUsingGuava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        String str = CharStreams.toString(reader);
    }
}
