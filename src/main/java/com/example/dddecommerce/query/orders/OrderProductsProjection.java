package com.example.dddecommerce.query.orders;

import com.example.dddecommerce.coreapi.AddProductEvent;
import com.example.dddecommerce.coreapi.OrderCreatedEvent;
import com.example.dddecommerce.coreapi.OrderProductsQuery;
import com.example.dddecommerce.coreapi.RemoveProductEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderProductsProjection {

  private final OrderProductsRepository repository;

  public OrderProductsProjection(OrderProductsRepository repository) { this.repository = repository; }

  @QueryHandler
  public List<String> handle(OrderProductsQuery query) {
    return repository.findOrderProductsByOrderId(query.getOrderId())
        .stream()
        .map(OrderProducts::getOrderId).sorted().collect(Collectors.toList());
  }

  @EventHandler
  public void on(OrderCreatedEvent event) {
    repository.save(new OrderProducts(event.getOrderId(), event.getCustomer()));
  }

  @EventHandler
  public void on(AddProductEvent event) {
    repository.save(new OrderProducts(event.getOrderId(), event.getProduct(), event.getPrice()));
  }

  @EventHandler
  public void on(RemoveProductEvent event) {
    repository.deleteByOrderIdAndProduct(event.getOrderId(), event.getProduct());
  }
}
