package com.masgotcode.northwind.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByEmailAddress(String emailAddress);
}
