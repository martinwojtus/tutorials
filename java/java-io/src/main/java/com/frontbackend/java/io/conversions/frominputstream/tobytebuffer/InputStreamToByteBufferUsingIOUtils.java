package com.frontbackend.java.io.conversions.frominputstream.tobytebuffer;

import static java.nio.channels.Channels.newChannel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.IOUtils;

public class InputStreamToByteBufferUsingIOUtils {

    public static void main(String[] args) throws IOException {
        InputStream initialStream = new ByteArrayInputStream(new byte[] { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 });

        ByteBuffer byteBuffer = ByteBuffer.allocate(initialStream.available());
        ReadableByteChannel channel = newChannel(initialStream);
        IOUtils.readFully(channel, byteBuffer);
    }
}
