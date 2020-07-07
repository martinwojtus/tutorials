package com.frontbackend.java.io.working.dir;

public class WorkingDirectory {

    public static void main(String[] args) {
        String userDirectory = System.getProperty("user.dir");
        System.out.println("Working dir = " + userDirectory);
    }
}
