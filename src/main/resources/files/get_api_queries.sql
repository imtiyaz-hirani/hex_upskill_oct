show databases;
use trs_oct;

describe customers; 
insert into plans values (1,"PLAN A", 300);
insert into plans values (2,"PLAN BA", 500);
insert into customers values (2,"ronald", "kent");
insert into customer_plan values (1,null,1,1);
insert into customer_plan values (2,null,1,2);
insert into customer_plan values (3,null,2,2);
 
# Display all plans for given customer - id
select p.*
from customers c 
JOIN customer_plan cp ON c.id = cp.customer_id 
JOIN plans p ON cp.plan_id = p.id
where c.id=1;


# Display Tickets raised by given customer and assigned to an executive 

select id,priority,status,customer_id,executive_id from tickets; 
select * from executives;
insert into executives values (1,"2Line Exec","John Doe");
select * from customers; 

select t.*
from executives e  RIGHT JOIN 
tickets t ON e.id = t.executive_id JOIN
customers c ON t.customer_id = c.id 
where c.id=2 AND t.executive_id IS NOT NULL;  

select * from tickets; 

 
# Display Info with Customer and Executive details with plan

select * from tickets;
select * from executives;
select * from plans;
select * from customers;

select t.id, t.priority,t.status, t.created_at, c.city as cname, e.name as exe_name,e.job_title,p.plan_name,p.price
from customers c
LEFT JOIN tickets t ON c.id = t.customer_id
JOIN executives e ON t.executive_id = e.id
JOIN customer_plan cp ON c.id = cp.customer_id
JOIN plans p ON cp.plan_id = p.id;









