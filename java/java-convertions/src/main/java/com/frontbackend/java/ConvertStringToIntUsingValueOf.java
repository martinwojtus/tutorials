package com.frontbackend.java;

public class ConvertStringToIntUsingValueOf {

    public static void main(String[] args) {
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
}
