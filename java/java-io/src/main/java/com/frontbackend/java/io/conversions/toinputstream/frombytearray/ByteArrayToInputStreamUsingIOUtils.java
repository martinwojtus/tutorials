package com.frontbackend.java.io.conversions.toinputstream.frombytearray;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class ByteArrayToInputStreamUsingIOUtils {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);

        InputStream inputStream = IOUtils.toInputStream(new String(bytes), StandardCharsets.UTF_8);
    }
}
