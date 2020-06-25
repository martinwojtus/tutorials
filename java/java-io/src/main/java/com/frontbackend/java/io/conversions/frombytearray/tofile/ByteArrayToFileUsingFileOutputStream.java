package com.frontbackend.java.io.conversions.frombytearray.tofile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteArrayToFileUsingFileOutputStream {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);
        try (FileOutputStream fos = new FileOutputStream("/tmp/output.txt")) {
            fos.write(bytes);
        }
    }
}
