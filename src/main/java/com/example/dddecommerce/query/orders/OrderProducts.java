package com.example.dddecommerce.query.orders;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class OrderProducts {

    @Id
    @GeneratedValue
    private Long id;
    private String orderId;
    private String customer;
    private String product;
    private BigDecimal price;

    public OrderProducts(String orderId, String customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public OrderProducts(String orderId, String product, BigDecimal price) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
    }
}
