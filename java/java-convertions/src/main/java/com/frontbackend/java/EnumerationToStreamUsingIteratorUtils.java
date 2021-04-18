package com.frontbackend.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.collections4.IteratorUtils;

public class EnumerationToStreamUsingIteratorUtils {

    public static void main(String[] args) {
        Enumeration<String> enumeration = Collections.enumeration(Arrays.asList("one", "two", "three"));

        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(IteratorUtils.asIterator(enumeration), Spliterator.ORDERED);

        Stream<String> stream = StreamSupport.stream(spliterator, false);

        stream.forEach(System.out::println); // print elements from Stream
    }
}
