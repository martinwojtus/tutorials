package com.frontbackend.java.io.create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CreateFileUsingCommonsIO {

    public static void main(String[] args) throws IOException {
        FileUtils.touch(new File("/tmp/file5.txt"));
    }
}
