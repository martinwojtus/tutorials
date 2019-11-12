package com.frontbackend.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConvertListToStream {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> listStream = numberList.stream();

        System.out.println(Arrays.toString(listStream.toArray()));
    }
}
