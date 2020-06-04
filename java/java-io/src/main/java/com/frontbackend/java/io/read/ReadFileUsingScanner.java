package com.frontbackend.java.io.read;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileUsingScanner {

    public static void main(String[] args) throws IOException {
        File file = new File("/tmp/frontbackend.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");

        System.out.println(sc.next());
    }
}
