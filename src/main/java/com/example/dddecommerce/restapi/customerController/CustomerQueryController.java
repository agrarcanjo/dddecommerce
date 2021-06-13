package com.example.dddecommerce.restapi.customerController;

import com.example.dddecommerce.coreapi.CustomerAddressQuery;
import com.example.dddecommerce.query.address.Address;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

@RestController
public class CustomerQueryController {

  private final QueryGateway queryGateway;

  public CustomerQueryController(QueryGateway queryGateway) { this.queryGateway = queryGateway; }

  @GetMapping("/customer/{customerId}/address")
  public Future<List<Address>> productsInOrder(@PathVariable String customerId) {
    return queryGateway.query(new CustomerAddressQuery(customerId), new MultipleInstancesResponseType<>(Address.class));
  }
}
