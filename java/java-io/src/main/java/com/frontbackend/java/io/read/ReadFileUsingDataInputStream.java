package com.frontbackend.java.io.read;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileUsingDataInputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");

        String fileContent = null;

        DataInputStream reader = new DataInputStream(new FileInputStream(file));
        int bytesToRead = reader.available();
        if (bytesToRead > 0) {
            byte[] bytes = new byte[bytesToRead];
            reader.read(bytes);
            fileContent = new String(bytes);
        }

        System.out.println(fileContent);
    }
}
