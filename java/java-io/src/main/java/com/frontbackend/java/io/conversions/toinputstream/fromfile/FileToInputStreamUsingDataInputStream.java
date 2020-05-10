package com.frontbackend.java.io.conversions.toinputstream.fromfile;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileToInputStreamUsingDataInputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/input.txt");
        InputStream inputStream = new DataInputStream(new FileInputStream(file));
    }
}
