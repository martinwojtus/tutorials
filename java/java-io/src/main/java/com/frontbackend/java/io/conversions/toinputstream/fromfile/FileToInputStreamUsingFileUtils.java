package com.frontbackend.java.io.conversions.toinputstream.fromfile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class FileToInputStreamUsingFileUtils {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/input.txt");

        InputStream inputStream = FileUtils.openInputStream(file);
    }
}
