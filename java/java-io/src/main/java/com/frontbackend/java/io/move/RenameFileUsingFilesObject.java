package com.frontbackend.java.io.move;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RenameFileUsingFilesObject {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/fileToRename.txt");
        File dest = new File("/tmp/out.txt");

        Files.move(file.toPath(), dest.toPath());
    }
}
