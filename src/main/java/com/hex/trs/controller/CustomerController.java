package com.hex.trs.controller;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping("/signup")
    private ResponseEntity<?> postCustomer(@Valid @RequestBody CustomerReqDto customerReqDto){
        customerService.postCustomer(customerReqDto);
        return ResponseEntity
                .created(URI.create(""))
                .body("Customer Signed Up!!");
    }
}
