package com.frontbackend.java.io.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingTryWithResources {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
