package com.frontbackend.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConvertIntArrayToIntStream {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

        IntStream intStream = Arrays.stream(numbers);
        intStream = intStream.limit(3);

        System.out.println(intStream.sum());
    }
}
