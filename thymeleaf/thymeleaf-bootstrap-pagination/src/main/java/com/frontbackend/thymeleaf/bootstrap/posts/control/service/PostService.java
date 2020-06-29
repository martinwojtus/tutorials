package com.frontbackend.thymeleaf.bootstrap.posts.control.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.frontbackend.thymeleaf.bootstrap.posts.control.dao.PostDAO;
import com.frontbackend.thymeleaf.bootstrap.posts.entity.Post;
import com.frontbackend.thymeleaf.bootstrap.posts.entity.paging.Paged;
import com.frontbackend.thymeleaf.bootstrap.posts.entity.paging.Paging;

@Service
public class PostService {

    private final PostDAO postDAO;

    @Autowired
    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public Paged<Post> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, new Sort(Sort.Direction.ASC, "id"));
        Page<Post> postPage = postDAO.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }
}
