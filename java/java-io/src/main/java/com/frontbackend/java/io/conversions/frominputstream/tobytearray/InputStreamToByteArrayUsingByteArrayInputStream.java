package com.frontbackend.java.io.conversions.frominputstream.tobytearray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamToByteArrayUsingByteArrayInputStream {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        byte[] targetArray = new byte[initialStream.available()];
        initialStream.read(targetArray);
    }
}
