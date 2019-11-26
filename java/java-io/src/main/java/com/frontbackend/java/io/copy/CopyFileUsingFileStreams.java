package com.frontbackend.java.io.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileUsingFileStreams {

    public static void main(String[] args) throws IOException {
        File fileToCopy = new File("/tmp/frontbackend.txt");
        FileInputStream input = new FileInputStream(fileToCopy);

        File newFile = new File("/tmp/frontbackend.copy.txt");
        FileOutputStream output = new FileOutputStream(newFile);

        byte[] buf = new byte[1024];
        int bytesRead;

        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }

        input.close();
        output.close();
    }
}
