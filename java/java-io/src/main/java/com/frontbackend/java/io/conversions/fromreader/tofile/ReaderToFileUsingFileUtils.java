package com.frontbackend.java.io.conversions.fromreader.tofile;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ReaderToFileUsingFileUtils {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");
        byte[] bytes = IOUtils.toByteArray(reader, StandardCharsets.UTF_8);

        File file = new File("/tmp/output.txt");
        FileUtils.writeByteArrayToFile(file, bytes);
    }
}
