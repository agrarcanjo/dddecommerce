package com.example.dddecommerce.restapi.customerController;

import com.example.dddecommerce.coreapi.AddAddressCommand;
import com.example.dddecommerce.coreapi.CreateCustomerCommand;
import com.example.dddecommerce.exception.ResourceException;
import com.example.dddecommerce.query.address.Address;
import com.example.dddecommerce.restapi.dto.Customer;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
public class CustomerCommandController {

  private final CommandGateway commandGateway;

  public CustomerCommandController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping("/customer")
  public Future<String> createCustomer(@RequestBody @Valid Customer customer) {
    Assert.notNull(customer.getName(), "O nome é obrigatório");
    String customerId = customer.getCustomerId() == null ? UUID.randomUUID().toString() : customer.getCustomerId();
    return commandGateway.send(new CreateCustomerCommand(customerId, customer.getName(), customer.getEmail(), customer.getPassword(), customer.getCpf()));
  }

  @PostMapping("/customer/{customerId}/addAddress")
  @ExceptionHandler(ResourceException.class)
  public ResponseEntity<Future<Address>> addAddressCustomer(@PathVariable String customerId, @RequestBody @Valid String cep) {
    Assert.notNull(cep, "O CEP é obrigatório");
    Future<Address> obj = commandGateway.send(new AddAddressCommand(customerId,cep));
    if(obj.isDone())
      return new ResponseEntity<>(obj, HttpStatus.OK);
    else
      throw new ResourceException(HttpStatus.BAD_REQUEST, "Erro ao consultar CEP");
  }

}
