package com.example.dddecommerce.query.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {

  List<OrderProducts> findOrderProductsByOrderId(String orderId);

  void deleteByOrderIdAndProduct(String orderId, String product);
}
