package com.example.dddecommerce.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class Order {

    private String orderId;
    @NotEmpty
    private String customer;
}
