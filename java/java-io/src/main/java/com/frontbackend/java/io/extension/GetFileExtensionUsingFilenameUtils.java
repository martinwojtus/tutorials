package com.frontbackend.java.io.extension;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class GetFileExtensionUsingFilenameUtils {

    public static void main(String[] args) {

        File source = new File("/tmp/test.txt");
        String filename = source.getName();

        System.out.println(FilenameUtils.getExtension(filename));
        System.out.println(FilenameUtils.getExtension("test"));
    }
}
