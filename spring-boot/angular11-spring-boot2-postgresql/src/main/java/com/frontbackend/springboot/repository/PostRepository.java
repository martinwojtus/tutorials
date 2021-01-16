package com.frontbackend.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findAllByTitleContaining(String title);
}
