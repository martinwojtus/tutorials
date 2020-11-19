package com.frontbackend.libraries.mockito.resources;

import com.frontbackend.libraries.mockito.db.DBConnection;
import com.frontbackend.libraries.mockito.model.Post;

import java.util.Arrays;
import java.util.List;

public class PostResource {
    private final DBConnection dbConnection;

    public PostResource(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Post> getPosts() {
        try {
            dbConnection.open();
            return Arrays.asList(
                    new Post("title1", "content1"),
                    new Post("title2", "content2"),
                    new Post("title3", "content3"));
        } finally {
            dbConnection.close();
        }
    }
}
