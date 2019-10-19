package com.frontbackend.java.io.write;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileUsingFileWriter {

    public static void main(String[] args) {
        final String content = "FrontBackend.com";

        try (FileWriter fileWriter = new FileWriter("/tmp/test3.txt")) {
            fileWriter.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
