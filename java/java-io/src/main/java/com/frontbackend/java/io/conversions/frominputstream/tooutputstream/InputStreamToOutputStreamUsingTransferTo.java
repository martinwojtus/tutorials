package com.frontbackend.java.io.conversions.frominputstream.tooutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamToOutputStreamUsingTransferTo {

    public static void main(String[] args) throws IOException {
        try (InputStream in = new FileInputStream("/tmp/input.txt");
             OutputStream out = new FileOutputStream("/tmp/output.txt")) {

           // in.transferTo(out);
        }
    }
}
