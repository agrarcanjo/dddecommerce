package com.example.dddecommerce.service;

import com.example.dddecommerce.query.address.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    Address findAddressByCep(@PathVariable("cep") String cep);
}
