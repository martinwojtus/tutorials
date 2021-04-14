package com.frontbackend.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ConvertIterableToCollection {

    public static void main(String[] args) {
        Iterable<String> iterable = Arrays.asList("one", "two", "three");

        List<String> output1 = new ArrayList<>();
        iterable.forEach(output1::add);

        List<String> output2 = StreamSupport.stream(iterable.spliterator(), false)
                                            .collect(Collectors.toList());
    }
}
