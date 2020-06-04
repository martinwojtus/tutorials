package com.frontbackend.java.io.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadURLUsingBufferedReader {

    public static void main(String[] args) throws IOException {
        String line;
        StringBuffer buff = new StringBuffer();

        URL url = new URL("http://www.google.com/");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            while ((line = in.readLine()) != null) {
                buff.append(line)
                    .append(System.lineSeparator());
            }
        }

        System.out.println(buff.toString());
    }
}
