package com.frontbackend.java;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.IterableUtils;

public class ConvertIterableToCollectionUsingIterableUtils {

    public static void main(String[] args) {
        Iterable<String> iterable = Arrays.asList("one", "two", "three");

        List<String> output = IterableUtils.toList(iterable);
    }
}
