package com.learning.java.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String lastName;
    String firstName;
    LocalDate dateOfBirth;
    String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;
}
