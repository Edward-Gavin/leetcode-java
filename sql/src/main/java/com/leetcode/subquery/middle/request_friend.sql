
-- 602. 好友申请 II ：谁有最多的好友
Create table If Not Exists RequestAccepted (requester_id int not null, accepter_id int null, accept_date date null);
Truncate table RequestAccepted;
insert into RequestAccepted (requester_id, accepter_id, accept_date) values ('1', '2', '2016/06/03');
insert into RequestAccepted (requester_id, accepter_id, accept_date) values ('1', '3', '2016/06/08');
insert into RequestAccepted (requester_id, accepter_id, accept_date) values ('2', '3', '2016/06/08');
insert into RequestAccepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/09');

select
    *
from
    RequestAccepted
left join
    RequestAccepted RA
on
    RequestAccepted.requester_id = RA.accepter_id

select
    id, sum(cnt) as num
from (
         select requester_id as id, count(requester_id) as cnt
         from RequestAccepted
         group by requester_id

         union all

         select accepter_id as id , count(accepter_id) as cnt
         from RequestAccepted
         group by accepter_id

     ) as t
group by
    id
order by
    num desc
limit 1;

# Write your MySQL query statement below
select
    accepter_id as id,
    count(accepter_id) as num
from(
    select
        requester_id, accepter_id
    from RequestAccepted
    union
    select
        accepter_id as c1, requester_id as c2
    from RequestAccepted
    ) as t1
group by
    accepter_id
order by
    count(accepter_id) desc
limit 1
