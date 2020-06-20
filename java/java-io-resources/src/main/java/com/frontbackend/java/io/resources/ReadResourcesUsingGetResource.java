package com.frontbackend.java.io.resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class ReadResourcesUsingGetResource {

    public static void main(String[] args) throws IOException {
        ReadResourcesUsingGetResource obj = new ReadResourcesUsingGetResource();

        URL url = obj.getClass()
                     .getClassLoader()
                     .getResource("example.txt");

        File file = new File(url.getFile());
        String content = new String(Files.readAllBytes(file.toPath()));

        System.out.println(content);
    }
}
