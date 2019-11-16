package com.frontbackend.java.io.readonly;

import java.io.File;
import java.io.IOException;

public class SetReadOnlyUsingSetWritableMethod {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/test.txt");

        boolean status = file.setReadOnly();

        if (status) {
            System.out.println("File is read only");
        } else {
            System.out.println("File is not read only");
        }
    }
}
