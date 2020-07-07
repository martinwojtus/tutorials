package com.frontbackend.java.io.attributes;

import java.io.File;
import java.util.Date;

public class ModifiedDateUsingFile {

    public static void main(String[] args) {
        File file = new File("/tmp/frontbackend.txt");

        Date lastModifiedTime = new Date(file.lastModified());
        System.out.println(lastModifiedTime);
    }
}
