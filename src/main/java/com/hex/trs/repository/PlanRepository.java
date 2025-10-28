package com.hex.trs.repository;

import com.hex.trs.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Long> {
    @Query("""
            select p
            from Customer c
            JOIN CustomerPlan cp ON c.id = cp.customer.id
            JOIN Plan p ON cp.plan.id=p.id
            where c.id=?1
            """)
    List<Plan> getPlansByCustomer(long customerId);

    @Query(nativeQuery = true , value = """
            select p.*
            from customers c
            JOIN customer_plan cp ON c.id = cp.customer_id
            JOIN plans p ON cp.plan_id = p.id
            where c.id=?1
            """)
    List<Plan> getPlansByCustomerNativeQuery(long customerId);
}
/*
* # Display all plans for given customer - id
select p.*
from customers c
JOIN customer_plan cp ON c.id = cp.customer_id
JOIN plans p ON cp.plan_id = p.id
where c.id=1;
* */