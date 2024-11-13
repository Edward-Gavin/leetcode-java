-- 1731. 每位经理的下属员工数量


use leetcode;
Create table If Not Exists Employees_3(employee_id int, name varchar(20), reports_to int, age int);
Truncate table Employees_3;
insert into Employees_3 (employee_id, name, reports_to, age) values ('9', 'Hercy', NULL, '43');
insert into Employees_3 (employee_id, name, reports_to, age) values ('6', 'Alice', '9', '41');
insert into Employees_3 (employee_id, name, reports_to, age) values ('4', 'Bob', '9', '36');
insert into Employees_3 (employee_id, name, reports_to, age) values ('2', 'Winston', NULL, '37');

select
    *
from
    Employees_3 as e
left join
    Employees_3 as t
on
    e.employee_id = t.reports_to
where
    t.name is not null;

select
    e.employee_id,
    e.name,
    t.age
from
    Employees_3 as e
        left join
    Employees_3 as t
    on
            e.employee_id = t.reports_to
where
    t.name is not null;

select
    a.employee_id,
    a.name,
    count(a.name) as reports_count ,
    round(avg(a.age)) as average_age
from(
        select
            e.employee_id,
            e.name,
            t.age
        from
            Employees_3 as e
                left join
            Employees_3 as t
            on
                    e.employee_id = t.reports_to
        where
            t.name is not null
    ) as a
group by
    a.employee_id