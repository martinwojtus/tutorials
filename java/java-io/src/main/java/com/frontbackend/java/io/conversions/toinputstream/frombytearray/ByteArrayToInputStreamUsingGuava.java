package com.frontbackend.java.io.conversions.toinputstream.frombytearray;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.google.common.io.ByteSource;

public class ByteArrayToInputStreamUsingGuava {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        InputStream targetStream = ByteSource.wrap(bytes)
                                             .openStream();
    }
}
