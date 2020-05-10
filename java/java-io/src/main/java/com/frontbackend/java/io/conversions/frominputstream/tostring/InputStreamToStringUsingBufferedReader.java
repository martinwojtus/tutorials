package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamToStringUsingBufferedReader {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        System.out.println(out.toString());
        reader.close();
    }
}
