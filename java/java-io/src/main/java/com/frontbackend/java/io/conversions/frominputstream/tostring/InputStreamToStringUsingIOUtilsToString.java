package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class InputStreamToStringUsingIOUtilsToString {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        System.out.println(text);
    }
}
