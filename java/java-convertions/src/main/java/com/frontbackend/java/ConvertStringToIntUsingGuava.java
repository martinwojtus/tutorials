package com.frontbackend.java;

import com.google.common.primitives.Ints;

public class ConvertStringToIntUsingGuava {

    public static void main(String[] args) {
        System.out.println(Ints.tryParse("2212"));
        System.out.println(Ints.tryParse("-2212"));
        System.out.println(Ints.tryParse("asdf")); // null
    }
}
