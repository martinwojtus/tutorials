package com.frontbackend.thymeleaf.employee.service;

import com.frontbackend.thymeleaf.employee.model.Employee;
import com.frontbackend.thymeleaf.employee.model.EmployeePosition;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> generateEmployeeList() {
        return Arrays.asList(Employee.builder()
                                     .name("John Doe")
                                     .salary(5000.00)
                                     .position(EmployeePosition.MANAGER)
                                     .build(),
                Employee.builder()
                        .name("Dennison Kennett")
                        .salary(25000.00)
                        .position(EmployeePosition.SUPERVISOR)
                        .build(),
                Employee.builder()
                        .name("Juliana Hazleton")
                        .salary(10200.00)
                        .position(EmployeePosition.DIRECTOR)
                        .build());

    }
}
