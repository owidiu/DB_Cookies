package com.example.homework7.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerModel getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public void insert(CustomerModel customer) {
        customerRepository.save(customer);
    }

    public void update() {
        customerRepository.update();
    }

    public void delete() {
        customerRepository.delete();
    }

    public List<CustomerModel> getCustomers() {
        List<CustomerModel> customers = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }



}
