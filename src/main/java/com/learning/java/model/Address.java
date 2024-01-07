package com.learning.java.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zipCode;
}
