package com.frontbackend.java.io.conversions.frominputstream.tofile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamToFileUsingFileOutputStream {

    public static void main(String[] args) throws IOException {
        byte[] sampleBytes = { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 }; // frontbackend
        InputStream inputStream = new ByteArrayInputStream(sampleBytes);

        File file = new File("/tmp/output.txt");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}
