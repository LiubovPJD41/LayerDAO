select product_name
from customers
         join orders on customers.id = orders.customer_id
where product_name = :name;