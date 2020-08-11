package com.frontbackend.java.util;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

public class ReadClassesFromJarFile {

    public static void main(String[] args) throws IOException {
        try (JarFile jar = new JarFile(new File("/tmp/commons-io-2.4.jar"))) {
            EnumerationUtils.enumerationAsStream(jar.entries())
                            .filter(jarEntry -> jarEntry.getName()
                                                        .endsWith(".class"))
                            .forEach(jarEntry -> System.out.println(jarEntry.getName()));

        }
    }
}
