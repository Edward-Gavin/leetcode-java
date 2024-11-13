
-- 570. 至少有5名直接下属的经理
use leetcode;
Create table If Not Exists Employee_1 (id int, name varchar(255), department varchar(255), managerId
    int);
Truncate table Employee_1;
insert into Employee_1 (id, name, department, managerId) values (101, 'John', 'A', 0);
insert into Employee_1 (id, name, department, managerId) values (102, 'Dan', 'A', 101);
insert into Employee_1 (id, name, department, managerId) values (103, 'James', 'A', 101);
insert into Employee_1 (id, name, department, managerId) values (104, 'Amy', 'A', 101);
insert into Employee_1 (id, name, department, managerId) values (105, 'Anne', 'A', 101);
insert into Employee_1 (id, name, department, managerId) values (106, 'Ron', 'B', 101);

select name
from
    (select
        manager.name as name, count(report.id) as cnt
    from
        Employee_1 as manager
    join
        Employee_1 as report
    on
        manager.id = report.managerId
    group by
        manager.id) as count_t
where
    cnt >= 5;


select
    Manager.name as Name,
    count(Report.id) as cnt
from
    Employee_1 as Manager
join
    Employee_1 as Report
on
    Manager.id = Report.managerId
group by
    Manager.id;


select @@sql_mode;
set @@sql_mode ='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';