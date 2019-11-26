package com.frontbackend.java.io.copy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyFileUsingCommonIO {

    public static void main(String[] args) throws IOException {

        File source = new File("/tmp/frontbackend.txt");
        File dest = new File("/tmp/frontbackend.copy.txt");

        FileUtils.copyFile(source, dest);
    }
}
