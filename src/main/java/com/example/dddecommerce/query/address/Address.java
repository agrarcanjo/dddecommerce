package com.example.dddecommerce.query.address;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String customerId;
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;

    public Address(String customerId, String cep, String logradouro, String bairro, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.customerId = customerId;
    }

    public Address(String cep, String logradouro, String bairro, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
    }
}
