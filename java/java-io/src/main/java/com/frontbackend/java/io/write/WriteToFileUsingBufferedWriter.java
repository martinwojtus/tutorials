package com.frontbackend.java.io.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileUsingBufferedWriter {

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/test1.txt"))) {
            writer.write("FrontBackEnd.com");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
