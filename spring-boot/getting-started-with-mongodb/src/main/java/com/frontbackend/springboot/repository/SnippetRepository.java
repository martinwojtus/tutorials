package com.frontbackend.springboot.repository;

import com.frontbackend.springboot.model.Snippet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends MongoRepository<Snippet, String> {
}
