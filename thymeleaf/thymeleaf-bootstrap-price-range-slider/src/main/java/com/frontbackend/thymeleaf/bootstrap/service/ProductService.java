package com.frontbackend.thymeleaf.bootstrap.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frontbackend.thymeleaf.bootstrap.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

    public List<Product> filterProducts(int min, int max) {
        return getMockedProducts().stream()
                                  .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                                  .collect(Collectors.toList());
    }

    public List<Product> getMockedProducts() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(getClass().getClassLoader()
                                                    .getResourceAsStream("mockedProducts.json"),
                    new TypeReference<List<Product>>() {
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return Collections.emptyList();
    }
}
