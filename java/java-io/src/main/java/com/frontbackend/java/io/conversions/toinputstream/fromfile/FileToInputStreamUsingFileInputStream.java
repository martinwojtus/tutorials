package com.frontbackend.java.io.conversions.toinputstream.fromfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileToInputStreamUsingFileInputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/input.txt");
        InputStream inputStream = new FileInputStream(file);
    }
}
