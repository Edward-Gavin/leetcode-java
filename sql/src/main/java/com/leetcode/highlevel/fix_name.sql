-- 1667. 修复表中的名字
Create table If Not Exists Users_3 (user_id int, name varchar(40));
Truncate table Users_3;
insert into Users_3 (user_id, name) values ('1', 'aLice');
insert into Users_3 (user_id, name) values ('2', 'bOB');


select user_id,
       concat(upper(left(name,1)), lower(right(name,length(name)-1))) as name
from Users_3
order by
    user_id


select

from
