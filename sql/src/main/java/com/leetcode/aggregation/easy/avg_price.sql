-- 1251. 平均售价
Create table If Not Exists Prices (product_id int, start_date date, end_date date, price int);
Create table If Not Exists UnitsSold (product_id int, purchase_date date, units int);
Truncate table Prices;
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-02-17', '2019-02-28', '5');
insert into Prices (product_id, start_date, end_date, price) values ('1', '2019-03-01', '2019-03-22', '20');
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-01', '2019-02-20', '15');
insert into Prices (product_id, start_date, end_date, price) values ('2', '2019-02-21', '2019-03-31', '30');
insert into Prices (product_id, start_date, end_date, price) values ('3', '2019-02-21', '2019-03-31', '30');

Truncate table UnitsSold;
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-02-25', '100');
insert into UnitsSold (product_id, purchase_date, units) values ('1', '2019-03-01', '15');
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-02-10', '200');
insert into UnitsSold (product_id, purchase_date, units) values ('2', '2019-03-22', '30');

select t.product_id, ifnull(ROUND(sum(units*price)/sum(units),2), 0) as average_price
from
    (select
        p.product_id,
        units,
        price
    from
        Prices as p
    left join
        UnitsSold as u
    on
        u.product_id = p.product_id
        and purchase_date between start_date and end_date
    ) as t
group by
    t.product_id
order by
    product_id;


SELECT
    Prices.product_id AS product_id,
    Prices.price * UnitsSold.units AS sales,
    UnitsSold.units AS units
FROM
    Prices
LEFT JOIN
    UnitsSold
ON
    Prices.product_id = UnitsSold.product_id
    AND (
            UnitsSold.purchase_date BETWEEN Prices.start_date AND Prices.end_date
        );