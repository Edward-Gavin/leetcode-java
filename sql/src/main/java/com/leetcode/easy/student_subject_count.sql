Create table If Not Exists leetcode.Students
(
    student_id   int,
    student_name varchar(20)
);
Create table If Not Exists leetcode.Subjects
(
    subject_name varchar(20)
);
Create table If Not Exists leetcode.Examinations
(
    student_id   int,
    subject_name varchar(20)
);
Truncate table leetcode.Students;
insert into Students (student_id, student_name)
values ('1', 'Alice');
insert into Students (student_id, student_name)
values ('2', 'Bob');
insert into Students (student_id, student_name)
values ('13', 'John');
insert into Students (student_id, student_name)
values ('6', 'Alex');
Truncate table leetcode.Subjects;
insert into Subjects (subject_name)
values ('Math');
insert into Subjects (subject_name)
values ('Physics');
insert into Subjects (subject_name)
values ('Programming');
Truncate table leetcode.Examinations;
insert into Examinations (student_id, subject_name)
values ('1', 'Math');
insert into Examinations (student_id, subject_name)
values ('1', 'Physics');
insert into Examinations (student_id, subject_name)
values ('1', 'Programming');
insert into Examinations (student_id, subject_name)
values ('2', 'Programming');
insert into Examinations (student_id, subject_name)
values ('1', 'Physics');
insert into Examinations (student_id, subject_name)
values ('1', 'Math');
insert into Examinations (student_id, subject_name)
values ('13', 'Math');
insert into Examinations (student_id, subject_name)
values ('13', 'Programming');
insert into Examinations (student_id, subject_name)
values ('13', 'Physics');
insert into Examinations (student_id, subject_name)
values ('2', 'Math');
insert into Examinations (student_id, subject_name)
values ('1', 'Math');


SELECT s.student_id,
       s.student_name,
       sub.subject_name,
       IFNULL(grouped.attended_exams, 0) AS attended_exams
FROM Students s
         CROSS JOIN
     Subjects sub
         LEFT JOIN
            (SELECT
                 student_id, subject_name, COUNT(*) AS attended_exams
            FROM
                Examinations
            GROUP BY
                student_id, subject_name
            ) as grouped
         ON
             s.student_id = grouped.student_id AND sub.subject_name = grouped.subject_name
ORDER BY s.student_id, sub.subject_name;

select s.student_id,
       s.student_name,
       e.subject_name,
       count(CASE e.subject_name
                 when e.subject_name is null then 0
                 else
                     1 end)
from (select *
      from Students
               cross join Subjects) as s
         left join Examinations as e on
    s.student_id = e.student_id and s.subject_name = e.subject_name
group by s.student_id, e.subject_name
order by s.student_id, e.subject_name;

select s.student_id, student_name, count(e.subject_name) as count_n
from (select
          a.student_id, a.student_name, b.subject_name
      from
          Students as a
      cross join
          Subjects as b) as s
left join
    Examinations as e
on
    s.student_id = e.student_id and s.subject_name = e.subject_name
group by
    s.student_id, e.subject_name;


select s.student_id, student_name, count(e.subject_name)
from (select
          a.student_id, a.student_name, b.subject_name
      from
          Students as a
              cross join
          Subjects as b) as s
left join
     Examinations as e
on
     s.student_id = e.student_id and s.subject_name = e.subject_name
group by s.student_id, s.subject_name;
