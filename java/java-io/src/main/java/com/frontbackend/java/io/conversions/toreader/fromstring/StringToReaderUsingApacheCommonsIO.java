package com.frontbackend.java.io.conversions.toreader.fromstring;

import java.io.Reader;

import org.apache.commons.io.input.CharSequenceReader;

public class StringToReaderUsingApacheCommonsIO {

    public static void main(String[] args) {
        String str = "frontbackend.com";
        Reader reader = new CharSequenceReader(str);
    }
}
