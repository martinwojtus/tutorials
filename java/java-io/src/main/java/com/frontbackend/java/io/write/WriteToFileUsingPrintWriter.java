package com.frontbackend.java.io.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFileUsingPrintWriter {

    public static void main(String[] args) throws IOException {
        final String content = "FrontBackend.com";

        FileWriter fileWriter = new FileWriter("/tmp/test4.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.printf("This %s blog is awesome", "frontbackend.com");
        printWriter.close();
    }
}
