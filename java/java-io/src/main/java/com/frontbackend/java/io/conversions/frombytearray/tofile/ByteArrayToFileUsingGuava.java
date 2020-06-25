package com.frontbackend.java.io.conversions.frombytearray.tofile;

import static com.google.common.io.Files.write;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteArrayToFileUsingGuava {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);
        File file = new File("/tmp/output.txt");
        write(bytes, file);
    }
}
