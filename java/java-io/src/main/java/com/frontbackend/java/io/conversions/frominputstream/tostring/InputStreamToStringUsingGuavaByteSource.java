package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;

public class InputStreamToStringUsingGuavaByteSource {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        ByteSource byteSource = new ByteSource() {
            @Override
            public InputStream openStream() throws IOException {
                return inputStream;
            }
        };

        String text = byteSource.asCharSource(Charsets.UTF_8)
                                .read();

        System.out.println(text);
    }
}
