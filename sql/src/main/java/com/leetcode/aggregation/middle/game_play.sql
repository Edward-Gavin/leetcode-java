
-- 550. 游戏玩法分析 IV
Create table If Not Exists Activity_1 (player_id int, device_id int, event_date date, games_played int);
Truncate table Activity_1;
insert into Activity_1 (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-01', '5');
insert into Activity_1 (player_id, device_id, event_date, games_played) values ('1', '2', '2016-03-02', '6');
insert into Activity_1 (player_id, device_id, event_date, games_played) values ('2', '3', '2017-06-25', '1');
insert into Activity_1 (player_id, device_id, event_date, games_played) values ('3', '1', '2016-03-02', '0');
insert into Activity_1 (player_id, device_id, event_date, games_played) values ('3', '4', '2018-07-03', '5');

select
    ifnull(round(count(distinct result.player_id) / count(distinct Activity_1.player_id), 2), 0) as fraction
from(
        select
            expected.player_id as player_id
        from (
                 select
                     player_id,
                     DATE_ADD(min(event_date), interval 1 day ) as second_sign
                 from
                     Activity_1
                 group by
                     player_id
             )as expected, Activity_1
        where
                expected.player_id = Activity_1.player_id and expected.second_sign = Activity_1.event_date
    ) as result, Activity_1