#1 first name starts with Sa
SELECT `first_name`,`last_name` 
FROM `employees`
where 'Sa'=substring(`first_name`,1,2)
order by `employee_id`;

#2 where last name contains 'ei'
SELECT `first_name`,`last_name` 
FROM `employees`
  where `last_name` LIKE '%ei%'
order by `employee_id`;

#3 dept id is either 3 or 10, hire year is between 95-05
SELECT first_name 
FROM employees
where department_id in (3,10)
 and YEAR (hire_date) between 1995 and 2005
 order by employee_id;
 
#4 where job title is not engineer
SELECT first_name, last_name 
FROM employees
where job_title NOT LIKE '%engineer%'
order by employee_id;

#5 name length is 5 or 6 
SELECT `name` 
FROM towns
where char_length(`name`) in (5,6)
order by `name` asc;

#6 where name starts with m,k,b,e
SELECT town_id,`name` 
FROM towns
where `name`  regexp '^[MmKkBbEe]'
order by `name` asc;

#7  where name doesnt start with R,b,d
SELECT town_id,`name` 
FROM towns
where `name`  not regexp '^[RrBbDd]'
order by `name` asc;
#8
create view v_employees_hired_after_2000 as
SELECT first_name,last_name
 FROM employees
 where YEAR(hire_date) >2000;
 select * from v_employees_hired_after_2000 ;
 
 #9 where last name is exactly 5 letters
 SELECT first_name,last_name
 FROM employees
 where char_length(last_name) =5;
 
 #10  with geography DB , find names containing atleast 3 times 'a'
 SELECT country_name, iso_code
FROM countries
where char_length(country_name) - char_length(replace(lower(country_name),'a',''))>=3
order by iso_code;
 #11
 select 
peak_name,
river_name,
lower(concat(peak_name, substring(river_name,2))) as mix
from peaks,
 rivers
 where right(peak_name,1) =left(river_name,1)
 order by mix;
 
 #12 Diablo DB, 
 SELECT `name`, date_format(`start`,'%Y-%m-%d') as `start`
 FROM games
 where year(`start`) =2011 or year(`start`) =2012
 order by start,name
 limit 50;
 #13 filter the email domain 
 SELECT user_name,
SUBSTRING(email, LOCATE('@', email) + 1) as `email_provider`
 FROM users
 order by `email_provider`,user_name;
 
 #14
 SELECT user_name,ip_address
 FROM users
 where ip_address like '___.1%.%.___'
order by user_name ;

#15
SELECT `name` as 'game', 
 case
 when  hour(`start`) between 0 and 11 then 'Morning'
 when hour(`start`) between 12 and 17 then 'Afternoon'
else 'Evening'
End as 'Part of the Day',
Case 
when `duration` <=3 then 'Extra Short'
when `duration` between 4 and 6 then 'Short'
when `duration` between 7 and 10 then 'Long'
else 'Extra Long'
end as 'Duration'
FROM `games`
order by `name`;

#16 
SELECT product_name, 
order_date as 'Order Date',
date_add(order_date, interval 3 Day) as 'pay_due',
date_add(order_date, interval 1 month) as 'deliver_due'
 FROM orders;