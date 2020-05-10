package com.frontbackend.java.io.conversions.frominputstream.toreader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;

public class InputStreamToReaderUsingGuava {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("frontbackend.com".getBytes());

        byte[] buffer = ByteStreams.toByteArray(inputStream);
        Reader reader = CharSource.wrap(new String(buffer))
                                  .openStream();
    }
}
