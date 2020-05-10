package com.frontbackend.java.io.conversions.toreader.fromstring;

import java.io.IOException;
import java.io.Reader;

import com.google.common.io.CharSource;

public class StringToReaderUsingGuava {

    public static void main(String[] args) throws IOException {
        String str = "frontbackend.com";
        Reader reader = CharSource.wrap(str)
                                  .openStream();
    }
}
