package com.example.dddecommerce.restapi.orderController;


import com.example.dddecommerce.coreapi.AddProductCommand;
import com.example.dddecommerce.coreapi.CreateOrderCommand;
import com.example.dddecommerce.coreapi.RemoveProductCommand;
import com.example.dddecommerce.restapi.dto.Order;
import com.example.dddecommerce.restapi.dto.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
public class OrderCommandController {

  private final CommandGateway commandGateway;

  public OrderCommandController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping("/orders")
  public Future<String> createOrder(@RequestBody @Valid Order order) {
    Assert.notNull(order.getCustomer(), "O cliente é obrigatório");
    String orderId = order.getOrderId() == null ? UUID.randomUUID().toString() : order.getOrderId();
    return commandGateway.send(new CreateOrderCommand(orderId, order.getCustomer()));
  }

  @PostMapping("/orders/{orderId}/addProduct")
  public Future<Void> addProductOrder(@PathVariable String orderId, @RequestBody @Valid Product product) {
    Assert.notNull(product.getName(), "Nome para o produto é obrigatório");
    return commandGateway.send(new AddProductCommand(orderId, product.getName(), product.getPrice()));
  }

  @PostMapping("/orders/{orderId}/removeProduct")
  public Future<Void> removeProductOrder(@PathVariable String orderId, @RequestBody @Valid Product product) {
    Assert.notNull(product.getName(), "Nome para o produto é obrigatório");
    return commandGateway.send(new RemoveProductCommand(orderId, product.getName()));
  }
}
