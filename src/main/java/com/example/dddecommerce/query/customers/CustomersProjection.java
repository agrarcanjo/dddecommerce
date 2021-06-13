package com.example.dddecommerce.query.customers;


import com.example.dddecommerce.coreapi.CustomerQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomersProjection {

  private final CustomersRepository repository;

  public CustomersProjection(CustomersRepository repository) {
    this.repository = repository;
  }

  @QueryHandler
  public Customers handle(CustomerQuery query) {
    return repository.findCustomersByCustomerId(query.getCustomerId());
  }

}
