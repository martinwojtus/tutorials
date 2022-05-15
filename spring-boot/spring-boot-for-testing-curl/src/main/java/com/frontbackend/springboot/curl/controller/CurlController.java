package com.frontbackend.springboot.curl.controller;

import com.frontbackend.springboot.curl.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CurlController {

    @RequestMapping("/log")
    public void log() {
    }

    @RequestMapping("/log/body")
    public void logBody(@RequestBody String body) {
        log.info("Request payload = {}", body);
    }

    @RequestMapping("/log/body/xml")
    public void logBodyXML(@RequestBody Customer customer) {
        log.info("Customer from Payload = {}", customer);
    }

    @RequestMapping("/log/body/json")
    public void logBodyJSON(@RequestBody Customer customer) {
        log.info("Customer from Payload = {}", customer);
    }
}
