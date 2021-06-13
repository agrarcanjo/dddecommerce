package com.example.dddecommerce.query.customers;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue
    private Long id;
    private String customerId;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public Customers(String customerId, String name, String cpf, String email, String password) {
        this.customerId = customerId;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }
}
