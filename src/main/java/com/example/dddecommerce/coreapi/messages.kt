package com.example.dddecommerce.coreapi

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal

data class CreateCustomerCommand(@TargetAggregateIdentifier val roomId: String, val participant: String)
data class AddProductCommand(@TargetAggregateIdentifier val orderId: String, val product: String, val price: BigDecimal)
data class RemoveProductCommand(@TargetAggregateIdentifier val orderId: String, val product: String)
data class CreateOrderCommand(@TargetAggregateIdentifier val orderId: String, val customer: String)

data class AddProductEvent(val orderId: String, val product: String, val price: BigDecimal)
data class RemoveroductEvent(val orderId: String, val product: String)
data class OrderCreatedEvent(val orderId: String, val customer: String)

class AllRoomsQuery
data class OrderProductsQuery(val orderId: String)
data class OrderTotalQuery(val orderId: String)
