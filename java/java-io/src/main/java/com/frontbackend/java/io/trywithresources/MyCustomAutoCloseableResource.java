package com.frontbackend.java.io.trywithresources;

public class MyCustomAutoCloseableResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        // close resource
    }
}
