package com.frontbackend.java.io.conversions.toreader.fromfile;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.CharSequenceReader;

public class FileToReaderUsingFileUtils {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/input.txt");

        byte[] bytes = FileUtils.readFileToByteArray(file);
        Reader reader = new CharSequenceReader(new String(bytes));
    }
}
