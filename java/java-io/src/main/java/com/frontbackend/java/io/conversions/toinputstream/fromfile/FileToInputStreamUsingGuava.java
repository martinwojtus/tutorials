package com.frontbackend.java.io.conversions.toinputstream.fromfile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.Files;

public class FileToInputStreamUsingGuava {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/input.txt");

        InputStream inputStream = Files.asByteSource(file)
                                       .openStream();
    }
}
