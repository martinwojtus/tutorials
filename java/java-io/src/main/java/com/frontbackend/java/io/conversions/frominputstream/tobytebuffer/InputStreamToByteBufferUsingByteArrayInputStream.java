package com.frontbackend.java.io.conversions.frominputstream.tobytebuffer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class InputStreamToByteBufferUsingByteArrayInputStream {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        ByteBuffer byteBuffer = ByteBuffer.allocate(initialStream.available());
        while (initialStream.available() > 0) {
            byteBuffer.put((byte) initialStream.read());
        }
    }
}
