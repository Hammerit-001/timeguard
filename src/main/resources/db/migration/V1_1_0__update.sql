CREATE TABLE department
(
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR (100)

);

ALTER TABLE employee ADD COLUMN department_id BIGINT, ADD FOREIGN KEY (department_id) REFERENCES department(department_id) ON DELETE RESTRICT;
