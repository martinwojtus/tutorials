package com.frontbackend.java.io.conversions.toinputstream.fromstring;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class StringToInputStreamUsingIOUtils {

    public static void main(String[] args) {
        String str = "frontbackend.com";

        InputStream inputStream = IOUtils.toInputStream(str, StandardCharsets.UTF_8);
    }
}
