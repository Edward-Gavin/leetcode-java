-- 197. 上升的温度

Create table If Not Exists leetcode.Weather (id int, recordDate date, temperature int);
Truncate table leetcode.Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

use leetcode;
select
    a.id
from
    Weather as a
        cross join
    Weather as b
    on timestampdiff(day, a.recordDate, b.recordDate) = -1
where a.Temperature > b.Temperature;