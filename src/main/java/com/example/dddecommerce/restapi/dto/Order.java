package com.example.dddecommerce.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private String orderId;
    @NotEmpty
    private String customer;
}
