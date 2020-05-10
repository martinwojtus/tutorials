package com.frontbackend.java.io.conversions.fromreader.tofile;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import com.google.common.io.CharStreams;
import com.google.common.io.Files;

public class ReaderToFileUsingGuava {

    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("frontbackend.com");

        byte[] bytes = CharStreams.toString(reader)
                                  .getBytes(StandardCharsets.UTF_8);

        File file = new File("/tmp/output.txt");
        Files.write(bytes, file);
    }
}
