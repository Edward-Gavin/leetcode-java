-- 196. 删除重复的电子邮箱
Create table If Not Exists Person (id int, email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');


delete from
    Person
where id not in (
        select
            min_id
        from (
           select
               min(id) as min_id
           from
               Person
           group by
               email
       )as t
    );
