package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class InputStreamToStringUsingIOUtilsCopy {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        String text = writer.toString();

        System.out.println(text);
    }
}
