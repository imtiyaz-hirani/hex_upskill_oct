package com.hex.trs.service;

import com.hex.trs.model.Customer;
import com.hex.trs.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer ID Invalid"));
    }
}
