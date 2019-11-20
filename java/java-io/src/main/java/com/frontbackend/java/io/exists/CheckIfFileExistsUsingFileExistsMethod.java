package com.frontbackend.java.io.exists;

import java.io.File;
import java.io.IOException;

public class CheckIfFileExistsUsingFileExistsMethod {

    public static void main(String[] args) {
        File temp;
        try {
            temp = File.createTempFile("frontbackend", ".txt");

            boolean exists = temp.exists();

            System.out.println("File exists: " + exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
