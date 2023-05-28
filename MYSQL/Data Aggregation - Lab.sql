#1 group by dept id 
SELECT department_id,
count(*) as 'Number of employees'
 FROM employees
 group by department_id;
 # 2  avg. salary
 SELECT 
    department_id, ROUND(AVG(salary), 2) AS 'Total Salary'
FROM
    employees AS e
GROUP BY department_id
ORDER BY department_id;
#3 min salary >800, group by dept id 
SELECT 
    `department_id`, ROUND(MIN(`salary`), 2) AS `Min Salary`
FROM
    `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800;
 
 #4 count all products where price is over 8 and id is 2
 SELECT 
    COUNT(*) AS 'Count'
FROM
    `products`
WHERE
    `category_id` = 2 AND `price` > 8;
    
    #5
    SELECT 
    `category_id`,
    ROUND(AVG(`price`), 2) AS 'Average Price',
    ROUND(MIN(`price`), 2) AS 'Cheapest Product',
    ROUND(MAX(`price`), 2) AS 'Most Expensive Product'
FROM
    `products`
GROUP BY category_id;
    