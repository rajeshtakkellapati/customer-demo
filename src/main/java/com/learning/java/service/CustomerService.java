package com.learning.java.service;

import com.learning.java.model.Address;
import com.learning.java.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService {
    public List<Customer> getAllCustomers(){
        Customer customer = Customer.builder()
                .id(UUID.randomUUID())
                .firstName("Rajesh")
                .lastName("Takkellapati")
                .dateOfBirth(LocalDate.of(1991, Month.JULY, 23))
                .phone("+1(770)524-0496")
                .address(Address.builder()
                        .addressLine1("12103 Cypress Ct")
                        .city("Alpharetta")
                        .state("GA")
                        .zipCode("30005")
                        .build())
                .build();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        return customerList;
    }
}
