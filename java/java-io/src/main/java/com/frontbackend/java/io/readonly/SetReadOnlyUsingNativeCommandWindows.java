package com.frontbackend.java.io.readonly;

import java.io.File;
import java.io.IOException;

public class SetReadOnlyUsingNativeCommandWindows {

    public static void main(String[] args) throws IOException {
        File readOnlyFile = new File("c:/temp/test.txt");

        Runtime.getRuntime()
               .exec("attrib " + "" + readOnlyFile.getAbsolutePath() + "" + " +R");
    }
}
