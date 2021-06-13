package com.example.dddecommerce.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class Customer {

    @NotEmpty
    private String name;
    private String customerId;
    private String cpf;
    private String email;
    private String password;
}
