package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class InputStreamToStringUsingFiles {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        Path tempFile = Files.createTempFile(UUID.randomUUID()
                                                 .toString(),
                UUID.randomUUID()
                    .toString());
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        String text = new String(Files.readAllBytes(tempFile));

        System.out.println(text);
    }
}
