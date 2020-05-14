package com.frontbackend.java.io.move;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RenameFileUsingGuava {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/fileToRename.txt");
        File dest = new File("/tmp/out.txt");

        FileUtils.moveFile(file, dest);
    }
}
