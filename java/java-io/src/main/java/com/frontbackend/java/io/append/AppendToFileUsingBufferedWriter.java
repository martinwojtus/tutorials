package com.frontbackend.java.io.append;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFileUsingBufferedWriter {

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/test1.txt", true))) {
            writer.newLine();
            writer.write("FrontBackEnd.com"); // text to append

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
