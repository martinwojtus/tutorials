package com.frontbackend.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {


    public static void main(String[] args) {
        // Get current datetime
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Format datetime using DateTimeFormatter
        String formatDateTime = currentDateTime.format(formatter);

        System.out.println(formatDateTime);

        // Format LocalDateTime using inbuilt formatters
        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("EEE, MMM d, ''yy")));
        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("h:mm a")));
        System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss")));
    }
}
