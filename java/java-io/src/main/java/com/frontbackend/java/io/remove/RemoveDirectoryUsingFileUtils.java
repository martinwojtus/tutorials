package com.frontbackend.java.io.remove;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RemoveDirectoryUsingFileUtils {

    public static void main(String[] args) throws IOException {
        FileUtils.deleteDirectory(new File("/tmp/first"));
    }
}
