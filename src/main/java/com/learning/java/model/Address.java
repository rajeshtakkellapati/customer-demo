package com.learning.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zipCode;
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    Customer customer;
}
