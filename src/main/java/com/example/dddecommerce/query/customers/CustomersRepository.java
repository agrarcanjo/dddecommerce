package com.example.dddecommerce.query.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

  Customers findCustomersByCustomerId(String customerId);

}
