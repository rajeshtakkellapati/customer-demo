package com.learning.java.controller;

import com.learning.java.model.Address;
import com.learning.java.model.Customer;
import com.learning.java.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CustomerController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getAllCustomersTest() throws Exception {
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

        given(customerService.getAllCustomers()).willReturn(customerList);

        mvc.perform(get("/api/v1/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(customerService, VerificationModeFactory.times(1)).getAllCustomers();

        reset(customerService);
    }
}
