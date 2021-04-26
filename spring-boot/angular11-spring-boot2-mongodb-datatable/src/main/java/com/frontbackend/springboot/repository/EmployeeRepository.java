package com.frontbackend.springboot.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, UUID> {
}
