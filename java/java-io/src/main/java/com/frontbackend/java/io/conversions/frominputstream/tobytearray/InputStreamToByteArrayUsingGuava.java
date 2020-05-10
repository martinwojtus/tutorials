package com.frontbackend.java.io.conversions.frominputstream.tobytearray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;

public class InputStreamToByteArrayUsingGuava {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        byte[] byteArray = ByteStreams.toByteArray(initialStream);
    }
}
