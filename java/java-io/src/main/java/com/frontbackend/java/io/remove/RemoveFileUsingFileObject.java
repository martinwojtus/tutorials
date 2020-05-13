package com.frontbackend.java.io.remove;

import java.io.File;
import java.io.IOException;

public class RemoveFileUsingFileObject {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/toremove.txt");
        if (file.delete()) {
            System.out.println("File successfully deleted");
        } else {
            System.out.println("File not deleted, probably it does not exist");
        }
    }
}
