package com.frontbackend.java.io.append;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendToFileUsingPrintWriter {

    public static void main(String[] args) throws IOException {

        final String textToAppend = "FrontBackend";

        FileWriter fileWriter = new FileWriter("/tmp/test3.txt", true); // true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(textToAppend);  // append new line
        printWriter.close();
    }
}
