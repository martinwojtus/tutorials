package com.frontbackend.java.io.trywithresources;

import java.io.Closeable;
import java.io.IOException;

public class MyCustomCloseableResource implements Closeable {

    @Override
    public void close() throws IOException {
        // close resource
    }
}
