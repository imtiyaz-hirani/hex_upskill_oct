package com.hex.trs.mapper;

import com.hex.trs.dto.CustomerReqDto;
import com.hex.trs.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerReqDto dto){
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setCity(dto.city());
        return customer;
    }
}
