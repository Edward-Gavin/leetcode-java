
Create table If Not Exists Products (product_id int, new_price int, change_date date);
Truncate table Products;
insert into Products (product_id, new_price, change_date) values ('1', '20', '2019-08-14');
insert into Products (product_id, new_price, change_date) values ('2', '50', '2019-08-14');
insert into Products (product_id, new_price, change_date) values ('1', '30', '2019-08-15');
insert into Products (product_id, new_price, change_date) values ('1', '5', '2019-08-16');
insert into Products (product_id, new_price, change_date) values ('2', '65', '2019-08-17');
insert into Products (product_id, new_price, change_date) values ('3', '20', '2019-08-18');


select
    p1.product_id,
    ifnull(p2.new_price, 10) as price
from (
    select
        distinct product_id
    from
        Products
     ) as p1 -- 所有的产品
left join (
    select
        product_id,
        new_price
    from
        Products
    where (product_id, change_date)
        in (
            select
                product_id,
                max(change_date)
            from
                Products
            where
                change_date <= '2019-08-16'
            group by
                product_id
        )
) as p2 -- 在 2019-08-16 之前有过修改的产品和最新的价格
on p1.product_id = p2.product_id
