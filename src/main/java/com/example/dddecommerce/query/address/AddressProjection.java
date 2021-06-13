package com.example.dddecommerce.query.address;

import com.example.dddecommerce.coreapi.AddAddressEvent;
import com.example.dddecommerce.coreapi.CustomerAddressQuery;
import com.example.dddecommerce.service.CepService;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressProjection {

  @Autowired
  private CepService cepService;
  private final AddressRepository repository;

  public AddressProjection(AddressRepository repository) { this.repository = repository; }

  @QueryHandler
  public List<Address> handle(CustomerAddressQuery query) {
    return repository.findAddressCustomerByCustomerId(query.getCustomerId());
  }

  @EventHandler
  public void on(AddAddressEvent event) throws Exception {
    Address address;
    try {
      address = cepService.findAddressByCep(event.getCep());
    } catch (Exception e) {
      throw new Exception("Erro ao consultar o CEP");
    }
    repository.save(new Address(event.getCustomerId(), address.getCep(), address.getLogradouro(), address.getBairro(), address.getUf()));
  }

}
