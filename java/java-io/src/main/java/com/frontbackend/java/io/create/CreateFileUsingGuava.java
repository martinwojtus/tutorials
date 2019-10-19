package com.frontbackend.java.io.create;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class CreateFileUsingGuava {

    public static void main(String[] args) throws IOException {
        Files.touch(new File("/tmp/file4.txt"));
    }
}
