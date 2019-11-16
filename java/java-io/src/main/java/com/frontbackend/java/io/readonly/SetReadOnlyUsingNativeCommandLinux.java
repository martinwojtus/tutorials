package com.frontbackend.java.io.readonly;

import java.io.File;
import java.io.IOException;

public class SetReadOnlyUsingNativeCommandLinux {

    public static void main(String[] args) throws IOException {
        File readOnlyFile = new File("/tmp/test.txt");

        Runtime.getRuntime()
               .exec("chmod 0444 " + "" + readOnlyFile.getAbsolutePath());
    }
}
