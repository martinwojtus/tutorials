package com.frontbackend.java.io.write;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFileUsingFileOutputStream {

    public static void main(String[] args)  {
        final String content = "FrontBackEnd.com";

        try (FileOutputStream outputStream = new FileOutputStream("/tmp/test2.txt")) {
            byte[] strToBytes = content.getBytes();
            outputStream.write(strToBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
