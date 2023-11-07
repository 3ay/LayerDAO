select o.productName from OrdersDAO o
                              inner join o.customer c
where lower(c.name) = lower(:name)