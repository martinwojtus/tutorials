package com.frontbackend.java.io.conversions.toinputstream.frombytearray;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ByteArrayToInputStreamUsingByteArrayInputStream {

    public static void main(String[] args) {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        InputStream targetStream = new ByteArrayInputStream(bytes);
    }
}
