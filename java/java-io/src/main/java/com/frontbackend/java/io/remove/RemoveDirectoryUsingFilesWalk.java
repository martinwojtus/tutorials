package com.frontbackend.java.io.remove;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class RemoveDirectoryUsingFilesWalk {

    public static void main(String[] args) throws IOException {
        Path toDelete = Paths.get("/tmp/first");

        Files.walk(toDelete)
             .sorted(Comparator.reverseOrder())
             .map(Path::toFile)
             .forEach(File::delete);
    }
}
