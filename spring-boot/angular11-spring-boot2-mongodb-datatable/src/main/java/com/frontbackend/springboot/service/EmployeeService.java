package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.frontbackend.springboot.model.Employee;
import com.frontbackend.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        return employeeRepository.save(employee);
    }

    public void removeAll(List<UUID> ids) {
        ids.forEach(employeeRepository::deleteById);
    }

    public Optional<Employee> get(UUID uuid) {
        return employeeRepository.findById(uuid);
    }

    public List<Employee> list() {
        return employeeRepository.findAll();
    }
}
