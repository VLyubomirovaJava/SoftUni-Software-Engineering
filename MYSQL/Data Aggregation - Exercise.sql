use gringotts; 
#1
select count(*) as 'count'
 FROM wizzard_deposits;
 #2
 SELECT 
    MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM
    wizzard_deposits;
    #3
    SELECT 
    deposit_group, MAX(magic_wand_size) AS longest_magic_wand
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY longest_magic_wand , deposit_group;
#4
SELECT 
    deposit_group
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size)
LIMIT 1;
#5
SELECT 
    deposit_group, SUM(deposit_amount) AS total_sum
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum
;
#6
SELECT 
    deposit_group, SUM(deposit_amount) AS total_sum
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group
;

#7
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC
;
#8
SELECT 
    deposit_group,
    magic_wand_creator,
    MIN(deposit_charge) AS 'min_deposit_charge'
FROM
    wizzard_deposits
GROUP BY deposit_group , magic_wand_creator
ORDER BY magic_wand_creator , deposit_group;

#9 
SELECT 
(case 
when `age` <=10  then '[0-10]'
when `age` <=20 then '[11-20]'
when `age` <=30 then '[21-30]'
when `age` <=40 then '[31-40]'
when `age` <=50 then '[41-50]'
when `age` <=60 then '[51-60]'
else '[61+]'
 end) as 'age_group',
 count(*) as `wizard_count`
 FROM `wizzard_deposits`
 group by `age_group`
 order by `age_group`;
 
 #10
 SELECT 
left(first_name,1) as `First letter`
 FROM 
wizzard_deposits
where deposit_group='Troll Chest'
group by `First letter`
order by `First letter`;

#11
SELECT 
deposit_group,
is_deposit_expired,
avg(deposit_interest) as average_interest
 FROM wizzard_deposits
 where
 deposit_start_date > '1985-01-01'
 group by deposit_group,
is_deposit_expired
order by deposit_group desc, is_deposit_expired
 ;
 
 #12
 SELECT department_id, min(salary) as `minimum_salary`
 FROM employees
 where department_id in (2,5,7)
 and hire_date >'2000/01/01 00:00:00.000000'
 group by department_id 
 order by  department_id asc;
 
 #13
 create table `hp_employees`
SELECT *
 FROM `employees`
 where salary >30000 and manager_id !=42;
 update hp_employees
 set salary=salary +5000
 where department_id=1;
 select department_id , avg(salary) as`avg_salary`
 from hp_employees
 group by department_id
 order by department_id;
 
 #14
 SELECT department_id, max(salary) as `max_salary`
from employees
group by department_id
having `max_salary` not between 30000 and 70000
order by department_id;

#15
SELECT count(salary)  as 'count'
FROM employees
where manager_id is null;
#16
SELECT 
    e.`department_id`,
    (SELECT DISTINCT
            e1.`salary`
        FROM
            `employees` AS e1
        WHERE
            e1.`department_id` = e.`department_id`
        ORDER BY e1.`salary` DESC
        LIMIT 1 OFFSET 2) AS `third_highest_salary`
FROM
    `employees` AS e
GROUP BY e.`department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY e.`department_id`;
#17

SELECT e.first_name,e.last_name,e.department_id
from employees as e 
where e.salary>(select avg(e1.salary)
from employees as e1
where e1.department_id=e.department_id)
order by department_id,employee_id
limit 10;

#18
SELECT department_id,sum(salary) as `total_salary`
from employees
group by department_id
order by department_id;
