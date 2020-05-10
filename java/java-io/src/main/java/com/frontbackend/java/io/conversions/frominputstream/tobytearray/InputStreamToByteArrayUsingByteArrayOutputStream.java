package com.frontbackend.java.io.conversions.frominputstream.tobytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamToByteArrayUsingByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = initialStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteArray = buffer.toByteArray();
    }
}
