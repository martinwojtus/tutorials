package com.frontbackend.libraries.mockito.service;

public class ThrowingService {

    public void someVoidMethod(int value) {
        System.out.println(1000 / value);
    }

    public int someNotVoidMethod(int value) {
        return 10000 / value;
    }
}
