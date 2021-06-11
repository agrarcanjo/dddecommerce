package com.example.dddecommerce.commandModel;

import com.example.dddecommerce.coreapi.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class Order {

    @AggregateIdentifier
    private String orderId;
    private String product;
    private String customer;
    private BigDecimal price;

    public Order() {}

    @CommandHandler
    public Order(CreateOrderCommand command){
        AggregateLifecycle.apply(new OrderCreatedEvent(command.getOrderId(), command.getCustomer()));
    }

    @CommandHandler
    public void handle(AddProductCommand command) {
        AggregateLifecycle.apply(new AddProductEvent(command.getOrderId(), command.getProduct(), command.getPrice()));
    }

    @CommandHandler
    public void handle(RemoveProductCommand command) {
        AggregateLifecycle.apply(new RemoveProductCommand(orderId, command.getProduct()));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.customer = event.getCustomer();
    }

    @EventSourcingHandler
    protected void on(AddProductEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
        this.price = event.getPrice();
    }

    @EventSourcingHandler
    protected void on(RemoveroductEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
    }

}
