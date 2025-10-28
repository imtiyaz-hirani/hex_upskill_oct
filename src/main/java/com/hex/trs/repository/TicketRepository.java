package com.hex.trs.repository;

import com.hex.trs.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query("""
            select t
            from Executive e
            RIGHT JOIN Ticket t ON t.executive = e
            JOIN Customer c ON t.customer = c
            where c.id = ?1 AND e IS NOT NULL
            """)
    List<Ticket> getTicketsByCustomer(Long customerId);
}
/*
* select t.*
from executives e  RIGHT JOIN
tickets t ON e.id = t.executive_id JOIN
customers c ON t.customer_id = c.id;
* */