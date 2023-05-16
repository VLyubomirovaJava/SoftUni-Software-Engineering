use `hotel`;
select `id`,`first_name`,`last_name`,`job_title`
from employees
order by `id`;

#1
Use `hotel`;
SELECT concat
(`first_name`, ' ',`last_name`) as `Full name`,
(`job_title`) as `Job title`,
(`salary`) as Salary from employees where salary >1000.0;

#2
Use `hotel`;
SELECT `id`, concat_ws (' ', `first_name` , `last_name`) as `full_name`,
`Job_title`,`Salary`
 from employees where salary >1000
order by `Id`;

#3
update `employees`
set `salary`=`salary` + 100 where `job_title` ='Manager';
select `salary` from `employees`;

#4
create view `view_employees` AS
select * from `employees` view_employees
order by `salary` desc
limit 1;
select * from `view_employees`;
#5
SELECT * FROM `employees`
where `salary` >=1000 and `department_id` =4
order by `id`;
#6
DELete from `employees` 
where `department_id`in (1,2);
select * from employees
order by id;