package com.frontbackend.thymeleaf.customers.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frontbackend.thymeleaf.customers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class CustomerService {

    public List<Customer> mockCustomers() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(getClass().getClassLoader()
                                                    .getResourceAsStream("mockedCustomers.json"),
                    new TypeReference<List<Customer>>() {
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
