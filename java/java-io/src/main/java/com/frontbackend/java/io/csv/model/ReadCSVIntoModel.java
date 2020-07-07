package com.frontbackend.java.io.csv.model;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ReadCSVIntoModel {

    public static void main(String[] args) throws IOException {
        CSVUserParser csvUserParser = new CSVUserParser();
        List<User> users = csvUserParser.parse(Paths.get("/tmp/username.csv"), User.class);
        System.out.println(users);
    }
}
