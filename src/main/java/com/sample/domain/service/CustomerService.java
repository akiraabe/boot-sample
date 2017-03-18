package com.sample.domain.service;

import com.sample.domain.model.Customer;
import com.sample.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sarah on 2017/03/18.
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void register(Customer customer) {
        customerRepository.save(customer);

    }

    public Customer getOne(String customerId) {
        return customerRepository.getOne(customerId);
    }
}
