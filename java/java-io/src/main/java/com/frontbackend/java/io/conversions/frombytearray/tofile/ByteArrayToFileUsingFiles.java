package com.frontbackend.java.io.conversions.frombytearray.tofile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ByteArrayToFileUsingFiles {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);

        File file = new File("/tmp/output.txt");
        Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
