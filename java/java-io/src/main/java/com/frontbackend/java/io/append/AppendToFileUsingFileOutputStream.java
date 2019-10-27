package com.frontbackend.java.io.append;

import java.io.FileOutputStream;
import java.io.IOException;

public class AppendToFileUsingFileOutputStream {

    public static void main(String[] args)  {
        final String content = "FrontBackEnd.com";

        try (FileOutputStream outputStream = new FileOutputStream("/tmp/test2.txt", true)) {
            byte[] strToBytes = content.getBytes();
            outputStream.write(strToBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
