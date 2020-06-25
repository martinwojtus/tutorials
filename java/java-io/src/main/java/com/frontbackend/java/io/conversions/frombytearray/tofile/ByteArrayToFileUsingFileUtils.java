package com.frontbackend.java.io.conversions.frombytearray.tofile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class ByteArrayToFileUsingFileUtils {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "frontbackend.com".getBytes(StandardCharsets.UTF_8);
        FileUtils.writeByteArrayToFile(new File("/tmp/output.txt"), bytes);
    }
}
