package com.frontbackend.java;

import com.google.common.primitives.Ints;

public class StringToIntConversion {

    public static void main(String[] args) {
        // Integer.parseInt
        integerParseInt();

        // Integer.valueOf
        integerValueOf();

        // Guava Ints.tryParse
        guavaIntsTryParse();
    }

    private static void guavaIntsTryParse() {
        System.out.println(Ints.tryParse("2212"));
        System.out.println(Ints.tryParse("-2212"));
        System.out.println(Ints.tryParse("asdf")); // null
    }

    private static void integerValueOf() {
        System.out.println(Integer.valueOf("6631")
                                  .getClass()); // class java.lang.Integer
        System.out.println(Integer.valueOf("-123631"));
        System.out.println(Integer.valueOf("8176"));

        try {
            System.out.println(Integer.valueOf("-12asdfads")); // java.lang.NumberFormatException:
                                                               // For input string: "tq123"
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void integerParseInt() {
        System.out.println(Integer.parseInt("123123"));
        System.out.println(Integer.parseInt("-19823"));

        try {
            System.out.println(Integer.parseInt("tq123")); // java.lang.NumberFormatException:
                                                           // For input string: "tq123"
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
