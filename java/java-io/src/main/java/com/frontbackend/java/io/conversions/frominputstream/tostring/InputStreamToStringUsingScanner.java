package com.frontbackend.java.io.conversions.frominputstream.tostring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputStreamToStringUsingScanner {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/tmp/frontbackend.txt");

        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        String text = scanner.hasNext() ? scanner.next() : "";

        System.out.println(text);
        scanner.close();
    }
}
