package com.learning.java.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    UUID id;
    String lastName;
    String firstName;
    LocalDate dateOfBirth;
    String phone;
    Address address;
}
