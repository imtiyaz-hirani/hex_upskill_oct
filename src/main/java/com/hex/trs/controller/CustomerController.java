package com.hex.trs.controller;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/ticket/info")
    public List<CustomerDto> getCustomerWithTicketsCount(){
        return customerService.getCustomerWithTicketsCount();
    }
}
