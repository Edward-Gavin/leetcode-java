
use leetcode;
Create table If Not Exists Products_1 (product_id int, product_name varchar(40), product_category varchar(40));
Create table If Not Exists Orders (product_id int, order_date date, unit int);
Truncate table Products_1;
insert into Products_1 (product_id, product_name, product_category) values ('1', 'Leetcode Solutions', 'Book');
insert into Products_1 (product_id, product_name, product_category) values ('2', 'Jewels of Stringology', 'Book');
insert into Products_1 (product_id, product_name, product_category) values ('3', 'HP', 'Laptop');
insert into Products_1 (product_id, product_name, product_category) values ('4', 'Lenovo', 'Laptop');
insert into Products_1 (product_id, product_name, product_category) values ('5', 'Leetcode Kit', 'T-shirt');
Truncate table Orders;
insert into Orders (product_id, order_date, unit) values ('1', '2020-02-05', '60');
insert into Orders (product_id, order_date, unit) values ('1', '2020-02-10', '70');
insert into Orders (product_id, order_date, unit) values ('2', '2020-01-18', '30');
insert into Orders (product_id, order_date, unit) values ('2', '2020-02-11', '80');
insert into Orders (product_id, order_date, unit) values ('3', '2020-02-17', '2');
insert into Orders (product_id, order_date, unit) values ('3', '2020-02-24', '3');
insert into Orders (product_id, order_date, unit) values ('4', '2020-03-01', '20');
insert into Orders (product_id, order_date, unit) values ('4', '2020-03-04', '30');
insert into Orders (product_id, order_date, unit) values ('4', '2020-03-04', '60');
insert into Orders (product_id, order_date, unit) values ('5', '2020-02-25', '50');
insert into Orders (product_id, order_date, unit) values ('5', '2020-02-27', '50');
insert into Orders (product_id, order_date, unit) values ('5', '2020-03-01', '50');


# Write your MySQL query statement below

select
    product_name,
    sum(unit)
from (
         select
             o.product_id,
             p.product_name,
             o.unit
         from
             Orders as o
         left join
             Products_1 as p
         on
            o.product_id = p.product_id
         where
             o.order_date between '2020-02-01' and '2020-02-29'
     ) as t
group by
    product_id
having
        sum(unit) >= 100;