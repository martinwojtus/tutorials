package com.frontbackend.java;

import org.apache.commons.collections4.IteratorUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EnumerationToStreamUsingSpliterator {

    public static void main(String[] args) {
        Enumeration<String> enumeration = Collections.enumeration(Arrays.asList("one", "two", "three"));

        Stream<String> stream = enumerationAsStream(enumeration); // convert Enumeration to Stream

        stream.forEach(System.out::println); // print elements from Stream
    }

    public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<T>() {
            @Override
            public T next() {
                return e.nextElement();
            }

            @Override
            public boolean hasNext() {
                return e.hasMoreElements();
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                while (e.hasMoreElements())
                    action.accept(e.nextElement());
            }
        }, Spliterator.ORDERED), false);
    }
}
