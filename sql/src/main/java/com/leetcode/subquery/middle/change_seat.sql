-- 626. 换座位
Create table If Not Exists Seat (id int, student varchar(255));
Truncate table Seat;
insert into Seat (id, student) values ('1', 'Abbot');
insert into Seat (id, student) values ('2', 'Doris');
insert into Seat (id, student) values ('3', 'Emerson');
insert into Seat (id, student) values ('4', 'Green');
insert into Seat (id, student) values ('5', 'Jeames');


select count(*) as cnt from Seat;

select
    case
        when MOD(id, 2) != 0 and cnt != id then id+1
        when MOD(id, 2) != 0 and cnt = id then id
        else id-1
    end as id,
    student
from Seat, (
    select count(*) as cnt from Seat
) as seat_count
order by
    id;

select
    case
        when cnt = id then id
        when MOD(id, 2) != 0 then id+1
        when MOD(id, 2) = 0 then id-1
    end as id, student
from Seat,(select count(1) as cnt from Seat) as temp
order by
    id;