package com.example.dddecommerce.commandModel;

import com.example.dddecommerce.coreapi.AddAddressCommand;
import com.example.dddecommerce.coreapi.AddAddressEvent;
import com.example.dddecommerce.coreapi.CreateCustomerCommand;
import com.example.dddecommerce.coreapi.CreateCustomerEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
public class Customer {

    @AggregateIdentifier
    private String customerId;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public Customer() {}

    @CommandHandler
    public Customer(CreateCustomerCommand command){
        AggregateLifecycle.apply(new CreateCustomerEvent(command.getCustomerId(), command.getName(), command.getEmail(), command.getPassword(), command.getCpf()));
    }

    @CommandHandler
    public void handle(AddAddressCommand command) {
        AggregateLifecycle.apply(new AddAddressEvent(command.getCustomerId(), command.getCep()));
    }

    @EventSourcingHandler
    protected void on(AddAddressEvent event) {
        this.customerId = event.getCustomerId();
    }

    @EventSourcingHandler
    protected void on(CreateCustomerEvent event) {
        this.customerId = event.getCustomerId();
        this.name= event.getName();
        this.cpf = event.getCpf();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }

}
