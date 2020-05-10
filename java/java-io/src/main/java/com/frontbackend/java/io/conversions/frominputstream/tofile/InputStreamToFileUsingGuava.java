package com.frontbackend.java.io.conversions.frominputstream.tofile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;

public class InputStreamToFileUsingGuava {

    public static void main(String[] args) throws IOException {
        byte[] bytes = { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 }; // frontbackend
        InputStream inputStream = new ByteArrayInputStream(bytes);

        File file = new File("/tmp/output.txt");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            ByteStreams.copy(inputStream, outputStream);
        }
    }
}
