package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputStreamToStringUsingByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int length;
        byte[] data = new byte[1024];

        while ((length = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, length);
        }

        String text = outputStream.toString(StandardCharsets.UTF_8.name());

        System.out.println(text);
    }
}
