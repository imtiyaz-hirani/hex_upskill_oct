package com.hex.trs.controller;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
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

    /*
    * Author: Imtiyaz
    * I am taking planId, and I need customer identity which i plan to ask spring.
    * */
    @PostMapping("/plan/{planId}")
    public ResponseEntity<?> purchasePlan(Principal principal, @PathVariable long planId){
        String customerUsername = principal.getName();
        customerService.purchasePlan(customerUsername,planId);
        return ResponseEntity.ok("Purchase Successful");
    }
}
