package com.frontbackend.java.io.remove;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RemoveFileUsingFilesObject {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/toremove.txt");
        Files.delete(file.toPath());
    }
}
