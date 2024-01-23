package com.learning.java.service;

import com.learning.java.model.Address;
import com.learning.java.model.Customer;
import com.learning.java.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService = new CustomerService();
    @Test
    void getCustomersTest() {
        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
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
        when(customerRepository.findAll()).thenReturn(customerList);
        assertNotNull(customerService.getAllCustomers());
    }
}
