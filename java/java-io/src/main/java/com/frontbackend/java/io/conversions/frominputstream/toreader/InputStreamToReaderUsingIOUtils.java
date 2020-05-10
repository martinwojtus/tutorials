package com.frontbackend.java.io.conversions.frominputstream.toreader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CharSequenceReader;

public class InputStreamToReaderUsingIOUtils {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("frontbackend.com".getBytes());

        byte[] buffer = IOUtils.toByteArray(inputStream);
        Reader reader = new CharSequenceReader(new String(buffer));
    }
}
