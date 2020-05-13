package com.frontbackend.java.io.remove;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RemoveFileUsingFileUtils {

    public static void main(String[] args) throws IOException {
        File file = FileUtils.getFile("/tmp/toremove.txt");
        FileUtils.forceDelete(file);
    }
}
