package com.frontbackend.springboot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontbackend.springboot.model.Employee;
import com.frontbackend.springboot.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable UUID id) {
        return employeeService.get(id)
                              .map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound()
                                                    .build());
    }

    @GetMapping
    public List<Employee> list() {
        return employeeService.list();
    }

    @PostMapping
    public UUID save(@RequestBody Employee employee) {
        return employeeService.save(employee)
                              .getId();
    }

    @PutMapping("{id}")
    public Employee edit(@PathVariable UUID id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.save(employee);
    }

    @PostMapping("/delete")
    public void remove(@RequestBody List<UUID> ids) {
        employeeService.removeAll(ids);
    }
}
