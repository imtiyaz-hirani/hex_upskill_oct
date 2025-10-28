package com.hex.trs.repository;

import com.hex.trs.dto.TicketPlanDto;
import com.hex.trs.model.Ticket;
import org.springframework.data.domain.Pageable;
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

    @Query("""
            select new com.hex.trs.dto.TicketPlanDto(t.id, t.priority,t.status,t.createdAt,c.city,e.name,e.jobTitle,p.planName,p.price)
            from Customer c
            LEFT JOIN Ticket t ON c=t.customer
            JOIN Executive e ON t.executive = e
            JOIN CustomerPlan cp ON cp.customer = c
            JOIN Plan p ON cp.plan = p
            """)
    List<TicketPlanDto> getTicketDetailsWithPlanInfo(Pageable pageable);
}
/*
*
select t.id, t.priority,t.status, t.created_at, c.city as cname, e.name as exe_name,e.job_title,p.plan_name,p.price
from customers c
LEFT JOIN tickets t ON c.id = t.customer_id
JOIN executives e ON t.executive_id = e.id
JOIN customer_plan cp ON c.id = cp.customer_id
JOIN plans p ON cp.plan_id = p.id;
* */
/*
* select t.*
from executives e  RIGHT JOIN
tickets t ON e.id = t.executive_id JOIN
customers c ON t.customer_id = c.id;
* */