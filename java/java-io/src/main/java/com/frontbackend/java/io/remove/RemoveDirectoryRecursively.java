package com.frontbackend.java.io.remove;

import java.io.File;

public class RemoveDirectoryRecursively {

    public static void main(String[] args) {
        deleteDirectory(new File("/tmp/first"));
    }

    private static void deleteDirectory(File dir) {
        File[] resources = dir.listFiles();
        if (resources != null) {
            for (File file : resources) {
                deleteDirectory(file);
            }
        }

        dir.delete();
    }
}
