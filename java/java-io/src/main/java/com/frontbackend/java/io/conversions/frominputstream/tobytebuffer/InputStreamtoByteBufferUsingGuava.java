package com.frontbackend.java.io.conversions.frominputstream.tobytebuffer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.google.common.io.ByteStreams;

public class InputStreamtoByteBufferUsingGuava {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        byte[] targetArray = ByteStreams.toByteArray(initialStream);
        ByteBuffer bufferByte = ByteBuffer.wrap(targetArray);
    }
}
