package com.hex.trs.repository;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("""
            select new com.hex.trs.dto.CustomerDto(c.id,c.city,count(c.id))
            from Customer c LEFT JOIN Ticket t ON t.customer = c
            group by c.id,c.city
            """)
    List<CustomerDto> getCustomerWithTicketsCount();

    @Query("""
            select c from Customer c where c.user.username=?1
            """)
    Customer getCustomerByUsername(String customerUsername);
}

/*
* select c.id, c.city, count(c.id) as number_of_tickets
from customers c LEFT JOIN tickets t ON c.id = t.customer_id
group by c.id, c.name
* */

/*
 * select c from Customer c JOIN User u ON c.user = u where u.username=?1
 * select c from Customer c JOIN c.user u where u.username=?1
 * select c from Customer c where c.user.username=?1
 */