package com.frontbackend.java.io.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class ReadFileUsingIOUtils {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/tmp/frontbackend.txt");
        String fileContent = IOUtils.toString(fis, StandardCharsets.UTF_8);

        System.out.println(fileContent);
    }
}
