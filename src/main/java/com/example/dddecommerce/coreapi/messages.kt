package com.example.dddecommerce.coreapi

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal

data class CreateCustomerCommand(@TargetAggregateIdentifier val customerId: String, val name: String, val email: String, val password: String, val cpf: String)
data class AddAddressCommand(@TargetAggregateIdentifier val customerId: String, val cep: String)

data class CreateCustomerEvent(val customerId: String, val name: String, val email: String, val password: String, val cpf: String);
data class AddAddressEvent(@TargetAggregateIdentifier val customerId: String, val cep: String)

data class AddProductCommand(@TargetAggregateIdentifier val orderId: String, val product: String, val price: BigDecimal)
data class RemoveProductCommand(@TargetAggregateIdentifier val orderId: String, val product: String)
data class CreateOrderCommand(@TargetAggregateIdentifier val orderId: String, val customer: String)

data class AddProductEvent(val orderId: String, val product: String, val price: BigDecimal)
data class RemoveProductEvent(val orderId: String, val product: String)
data class OrderCreatedEvent(val orderId: String, val customer: String)

class AllRoomsQuery
data class OrderProductsQuery(val orderId: String)
data class OrderTotalQuery(val orderId: String)

data class CustomerQuery(val customerId: String)
data class CustomerAddressQuery(val customerId: String)
