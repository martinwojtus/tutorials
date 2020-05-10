package com.frontbackend.java.io.conversions.toinputstream.fromstring;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.input.ReaderInputStream;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;

public class StringToInputStreamUsingGuava {

    public static void main(String[] args) throws IOException {
        String str = "frontbackend.com";

        InputStream result = new ReaderInputStream(CharSource.wrap(str)
                                                             .openStream(),
                Charsets.UTF_8);
    }
}
