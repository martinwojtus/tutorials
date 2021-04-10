package com.frontbackend.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.UserSession;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, String> {
}
