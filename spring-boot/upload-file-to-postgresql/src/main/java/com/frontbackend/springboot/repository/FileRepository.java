package com.frontbackend.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {
}
