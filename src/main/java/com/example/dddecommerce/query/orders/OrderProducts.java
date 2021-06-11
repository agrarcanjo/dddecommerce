package com.example.dddecommerce.query.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrderProducts {

    @Id
    @GeneratedValue
    private Long id;
    private String orderId;
    private String customer;
    private String product;
    private BigDecimal price;

    public OrderProducts() {}

    public OrderProducts(String orderId, String customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public OrderProducts(String orderId, String product, BigDecimal price) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
