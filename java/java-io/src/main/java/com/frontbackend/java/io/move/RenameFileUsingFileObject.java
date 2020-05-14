package com.frontbackend.java.io.move;

import java.io.File;

public class RenameFileUsingFileObject {

    public static void main(String[] args) {
        File file = new File("/tmp/fileToRename.txt");

        boolean renamed = file.renameTo(new File("/tmp/out.txt"));
        if (renamed) {
            System.out.println("File successfully renamed");
        } else {
            System.out.println("File cannot be renamed");
        }
    }
}
