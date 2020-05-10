package com.frontbackend.java.io.conversions.fromreader.tostring;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;

public class ReaderToStringUsingIOUtils {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        String str = IOUtils.toString(reader);
    }
}
