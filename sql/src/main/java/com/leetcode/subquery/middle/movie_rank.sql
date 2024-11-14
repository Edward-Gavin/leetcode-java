
Create table If Not Exists Movies (movie_id int, title varchar(30));
Create table If Not Exists Users_2 (user_id int, name varchar(30));
Create table If Not Exists MovieRating (movie_id int, user_id int, rating int, created_at date);
Truncate table Movies;
insert into Movies (movie_id, title) values ('1', 'Rebecca');

Truncate table Users_2;
insert into Users_2 (user_id, name) values ('1', 'Rebecca');

Truncate table MovieRating;
insert into MovieRating (movie_id, user_id, rating, created_at) values ('1', '1', '5', '2020-02-12');


(
    select
        name results
    from (
             select
                 user_id, count(1) as cnt
             from
                 MovieRating
             group by
                 user_id
         ) as t
             left join
         Users_2 as u
         on t.user_id = u.user_id
    order by
        cnt desc, name
    limit 1
)
union all
(
    select
        m.title as results
    from
        Movies as m
    left join (
        select
            movie_id,
            avg(rating) as rating
        from
            MovieRating
        where
                DATE_FORMAT(created_at, '%Y-%m') = '2020-02'
        group by
            movie_id
    ) as t
    on
        t.movie_id = m.movie_id
    order by
        t.rating desc, title
    limit 1
)

