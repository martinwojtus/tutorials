package com.frontbackend.thymeleaf.bootstrap.posts.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frontbackend.thymeleaf.bootstrap.posts.entity.Post;

public interface PostDAO extends JpaRepository<Post, Long> {
}
