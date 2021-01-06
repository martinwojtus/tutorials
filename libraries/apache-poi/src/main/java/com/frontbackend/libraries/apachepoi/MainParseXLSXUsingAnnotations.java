package com.frontbackend.libraries.apachepoi;

import java.io.InputStream;
import java.util.List;

import com.frontbackend.libraries.apachepoi.model.Post;
import com.frontbackend.libraries.apachepoi.parser.XLSXParser;

public class MainParseXLSXUsingAnnotations {

    public static void main(String[] args) {
        XLSXParser<Post> postsXLSXParser = new XLSXParser<>();

        InputStream xlsxFile = postsXLSXParser.getClass()
                                              .getClassLoader()
                                              .getResourceAsStream("posts.xlsx");
        try {
            List<Post> list = postsXLSXParser.parse(xlsxFile, Post.class);
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
