package com.frontbackend.java.io.conversions.toinputstream.fromstring;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StringToInputStreamUsingByteArrayInputStream {

    public static void main(String[] args) {
        String str = "frontbackend.com";

        InputStream result = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    }
}
