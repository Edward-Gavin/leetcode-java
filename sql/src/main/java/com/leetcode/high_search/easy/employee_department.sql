Create table If Not Exists Employee_4 (employee_id int, department_id int, primary_flag ENUM('Y','N'));
Truncate table Employee_4;
insert into Employee_4 (employee_id, department_id, primary_flag) values ('1', '1', 'N');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('2', '1', 'Y');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('2', '2', 'N');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('3', '3', 'N');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('4', '2', 'N');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('4', '3', 'Y');
insert into Employee_4 (employee_id, department_id, primary_flag) values ('4', '4', 'N');

with t as (
    select
        employee_id,
        department_id,
        primary_flag,
        count(*) over (partition by employee_id) as count_over
    from
        Employee_4
)

select
    employee_id,
    department_id
from
    t
where
    count_over=1
   or primary_flag='Y'
