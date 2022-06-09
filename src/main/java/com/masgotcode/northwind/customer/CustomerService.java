package com.masgotcode.northwind.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAllCustomers(){
        log.info("CustomerService.getAllCustomers");
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        log.info("CustomerService.getCustomerById["+id+"]");
        return customerRepository.findById(id);
    }
}
