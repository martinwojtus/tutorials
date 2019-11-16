package com.frontbackend.java.io.readonly;

import java.io.File;
import java.io.IOException;

public class SetReadOnlyUsingSetReadOnlyMethod {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/test.txt");

        boolean status = file.setWritable(false);

        System.out.println(status);

        if (file.canWrite()) {
            System.out.println("This file is writeable");
        } else {
            System.out.println("This file is read only");
        }
    }
}
