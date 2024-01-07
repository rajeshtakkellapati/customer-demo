package com.learning.java.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    CustomerService customerService = new CustomerService();
    @Test
    void getCustomersTest() {
        assertNotNull(customerService.getAllCustomers());
    }
}
