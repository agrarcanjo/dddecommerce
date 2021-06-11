package com.example.dddecommerce.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    @NotEmpty
    private String name;
    @DecimalMin(value = "0.00",message = "O preço mínimo é R$ 0.00")
    private BigDecimal price;
}
