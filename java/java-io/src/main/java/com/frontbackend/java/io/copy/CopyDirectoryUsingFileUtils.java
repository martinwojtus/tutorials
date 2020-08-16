package com.frontbackend.java.io.copy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyDirectoryUsingFileUtils {

    public static void main(String[] args) throws IOException {
        File sourceDirectory = new File("/tmp/from");
        File destinationDirectory = new File("/tmp/to");

        FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }
}
