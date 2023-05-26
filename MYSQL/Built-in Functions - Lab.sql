use book_library;
# 1 - find book titles begining with 'the' , order by id;
SELECT title FROM books where
substring(title,1,3) = 'The'
order by id;

#2 replace the in title with ***
SELECT replace (`title`, 'The' ,'***') as `Title` FROM books where
substring(title,1,3) = 'The'
order by id;

#3 sum of books price
select
round (sum(cost),2)
from books;

#4
select
concat_ws(' ',first_name,last_name) as `Full name`,
TIMESTAMPDIFF(day,born,died) as `Days Lived`
from authors;
#5
select
title from books
 where title  like 'Harry Potter%'
 order by id;