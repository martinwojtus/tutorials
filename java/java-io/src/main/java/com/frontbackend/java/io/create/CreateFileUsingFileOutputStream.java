package com.frontbackend.java.io.create;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileUsingFileOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("/tmp/file3.txt");
        out.close();
    }
}
