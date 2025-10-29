package com.hex.trs.service;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.mapper.CustomerMapper;
import com.hex.trs.mapper.UserMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.User;
import com.hex.trs.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer ID Invalid"));
    }

    public List<CustomerDto> getCustomerWithTicketsCount() {
        return customerRepository.getCustomerWithTicketsCount();
    }

    public void postCustomer(CustomerReqDto customerReqDto) {
        Customer customer =  customerMapper.toEntity(customerReqDto);
        User user = userMapper.toEntity(customerReqDto);
        // Encode password and Save User in DB
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userService.save(user);
        // Attach user to customer
        customer.setUser(user);
        // Save customer to DB
        customerRepository.save(customer);

    }
}
