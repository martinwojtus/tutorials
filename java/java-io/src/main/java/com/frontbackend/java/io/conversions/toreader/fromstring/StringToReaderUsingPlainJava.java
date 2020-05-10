package com.frontbackend.java.io.conversions.toreader.fromstring;

import java.io.Reader;
import java.io.StringReader;

public class StringToReaderUsingPlainJava {

    public static void main(String[] args) {
        String str = "frontbackend.com";
        Reader reader = new StringReader(str);
    }
}
