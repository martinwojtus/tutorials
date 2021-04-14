package com.frontbackend.java;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class ConvertIterableToCollectionUsingGuava {

    public static void main(String[] args) {
        Iterable<String> iterable = Arrays.asList("one", "two", "three");

        List<String> output = Lists.newArrayList(iterable);
    }
}
