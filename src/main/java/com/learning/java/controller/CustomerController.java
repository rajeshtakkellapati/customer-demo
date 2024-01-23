package com.learning.java.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.java.model.Customer;
import com.learning.java.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/v1/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
