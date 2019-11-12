package com.frontbackend.java;

public class ConvertStringToIntUsingParseInt {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("123123")); // 123123
        System.out.println(Integer.parseInt("-19823")); // -19823

        try {
            System.out.println(Integer.parseInt("tq123")); // this will throw java.lang.NumberFormatException:
            // For input string: "tq123"
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
