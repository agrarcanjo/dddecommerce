package com.example.dddecommerce.restapi;

import com.example.dddecommerce.coreapi.*;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

@RestController
public class QueryController {

  private final QueryGateway queryGateway;

  public QueryController(QueryGateway queryGateway) { this.queryGateway = queryGateway; }

  @GetMapping("/orders/{orderId}/products")
  public Future<List<String>> productsInOrder(@PathVariable String orderId) {
    return queryGateway.query(new OrderProductsQuery(orderId), new MultipleInstancesResponseType<>(String.class));
  }

  @GetMapping("/orders/{orderId}/total")
  public Future<List<String>> totalOrder(@PathVariable String orderId) {
    return queryGateway.query(new OrderTotalQuery(orderId), new MultipleInstancesResponseType<>(String.class));
  }

}
