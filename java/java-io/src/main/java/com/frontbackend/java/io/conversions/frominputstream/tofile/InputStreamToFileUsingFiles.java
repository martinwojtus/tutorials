package com.frontbackend.java.io.conversions.frominputstream.tofile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class InputStreamToFileUsingFiles {

    public static void main(String[] args) throws IOException {
        byte[] bytes = { 102, 114, 111, 110, 116, 98, 97, 99, 107, 101, 110, 100 }; // frontbackend
        InputStream inputStream = new ByteArrayInputStream(bytes);

        File file = new File("/tmp/output.txt");
        Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
