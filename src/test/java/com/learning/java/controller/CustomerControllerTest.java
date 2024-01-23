package com.learning.java.controller;

import com.learning.java.model.Address;
import com.learning.java.model.Customer;
import com.learning.java.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getAllCustomersTest() throws Exception {
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

        given(customerService.getAllCustomers()).willReturn(customerList);

        mvc.perform(get("/api/v1/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(customerService, VerificationModeFactory.times(1)).getAllCustomers();

        reset(customerService);
    }
}
