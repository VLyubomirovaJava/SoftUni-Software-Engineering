USE gamebar;
CREATE  TABLE employees(
id INT AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name  VARCHAR(30) NOT NULL,
PRIMARY KEY (id)
);
CREATE TABLE categories(
id INT AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
PRIMARY KEY (id)
);
CREATE TABLE products(
id INT AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
category_id INT NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO employees
VALUES
(1,'Gosho','Goshev' ),
(2,'Pesho','Peshev' ),
(3,'Tosho','Toshev');
ALTER TABLE employees
ADD COLUMN middle_name VARCHAR(20) NOT NULL;

ALTER TABLE employees
ADD CONSTRAINT fk_product_employees
FOREIGN KEY (category_id) REFERENCES categories( id);

 ALTER TABLE `employees`
MODIFY column `middle_name` VARCHAR(100);





