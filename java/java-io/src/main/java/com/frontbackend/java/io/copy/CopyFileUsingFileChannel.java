package com.frontbackend.java.io.copy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class CopyFileUsingFileChannel {

    public static void main(String[] args) throws IOException {

        RandomAccessFile source = new RandomAccessFile("/tmp/frontbackend.txt", "r");
        RandomAccessFile target = new RandomAccessFile("/tmp/frontbackend.copy.txt", "rw");

        FileChannel sfc = source.getChannel();
        FileChannel dfc = target.getChannel();

        dfc.transferFrom(sfc, 0, sfc.size());
    }
}
