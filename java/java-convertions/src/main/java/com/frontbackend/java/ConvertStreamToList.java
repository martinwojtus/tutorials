package com.frontbackend.java;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStreamToList {

    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4 };
        Stream<Integer> arrayStreams2 = Arrays.stream(numbers);

        System.out.println(arrayStreams2.collect(Collectors.toList()));
    }
}
