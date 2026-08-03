-- Create Database
CREATE DATABASE college_db;
-- Use Database
USE college_db;
-- Create Department Table
CREATE TABLE department(
dept_id INT PRIMARY KEY AUTO_INCREMENT,
dept_name VARCHAR(50) NOT NULL,
hod_name VARCHAR(50)
);
-- Create Course Table
CREATE TABLE course(
course_id INT PRIMARY KEY AUTO_INCREMENT,
course_name VARCHAR(50) NOT NULL,
duration VARCHAR(20)
);
-- Create Student Table
CREATE TABLE student(
student_id INT PRIMARY KEY AUTO_INCREMENT,
student_name VARCHAR(50) NOT NULL,
age INT,
gender VARCHAR(10),
email VARCHAR(100) UNIQUE,
dept_id INT,
course_id INT,
FOREIGN KEY(dept_id) REFERENCES department(dept_id),
FOREIGN KEY(course_id) REFERENCES course(course_id)
);
-- Show Tables
SHOW TABLES;
-- Describe Department Table
DESC department;
-- Describe Course Table
DESC course;
-- Describe Student Table
DESC student;
-- Insert Departments
INSERT INTO department(dept_name,hod_name)
VALUES
('Computer Science','Amit Sharma'),
('Electronics','Rakesh Verma'),
('Mechanical','Anjali Singh'),
('Civil','Pooja Gupta');
-- Display Department Table
SELECT * FROM department;
-- Insert Courses
INSERT INTO course(course_name,duration)
VALUES
('B.Tech','4 Years'),
('BCA','3 Years'),
('MCA','2 Years'),
('MBA','2 Years');
-- Display Course Table
SELECT * FROM course;
-- Insert Students
INSERT INTO student(student_name,age,gender,email,dept_id,course_id)
VALUES
('Rahul',21,'Male','rahul@gmail.com',1,1),
('Priya',22,'Female','priya@gmail.com',1,2),
('Aman',20,'Male','aman@gmail.com',2,1),
('Neha',23,'Female','neha@gmail.com',3,3),
('Rohit',22,'Male','rohit@gmail.com',4,4),
('Simran',21,'Female','simran@gmail.com',2,2);
-- Display Student Table
SELECT * FROM student;
-- Verify Relationship using Join
SELECT s.student_name,
d.dept_name,
c.course_name
FROM student s
INNER JOIN department d
ON s.dept_id=d.dept_id
INNER JOIN course c
ON s.course_id=c.course_id;
-- Create Unnormalized Table
CREATE TABLE student_record(
student_id INT,
student_name VARCHAR(50),
department_name VARCHAR(50),
hod_name VARCHAR(50),
course_name VARCHAR(50),
course_duration VARCHAR(20)
);
-- Describe Table
DESC student_record;
-- Insert Sample Data
INSERT INTO student_record
VALUES
(1,'Rahul','Computer Science','Amit Sharma','B.Tech','4 Years'),
(2,'Priya','Computer Science','Amit Sharma','BCA','3 Years'),
(3,'Aman','Electronics','Rakesh Verma','B.Tech','4 Years');
-- Display Data
SELECT * FROM student_record;
-- Create Department Table (1NF)
CREATE TABLE department(
dept_id INT PRIMARY KEY AUTO_INCREMENT,
dept_name VARCHAR(50),
hod_name VARCHAR(50)
);
-- Insert Department Data
INSERT INTO department(dept_name,hod_name)
VALUES
('Computer Science','Amit Sharma'),
('Electronics','Rakesh Verma');
-- Display Department
SELECT * FROM department;
-- Create Course Table (2NF)
CREATE TABLE course(
course_id INT PRIMARY KEY AUTO_INCREMENT,
course_name VARCHAR(50),
duration VARCHAR(20)
);
-- Insert Course Data
INSERT INTO course(course_name,duration)
VALUES
('B.Tech','4 Years'),
('BCA','3 Years');
-- Display Course
SELECT * FROM course;
-- Create Student Table (3NF)
CREATE TABLE student(
student_id INT PRIMARY KEY AUTO_INCREMENT,
student_name VARCHAR(50),
dept_id INT,
course_id INT,
FOREIGN KEY(dept_id) REFERENCES department(dept_id),
FOREIGN KEY(course_id) REFERENCES course(course_id)
);
-- Insert Student Data
INSERT INTO student(student_name,dept_id,course_id)
VALUES
('Rahul',1,1),
('Priya',1,2),
('Aman',2,1);
-- Display Student Table
SELECT * FROM student;
-- Verify Normalized Data
SELECT s.student_name,
d.dept_name,
d.hod_name,
c.course_name,
c.duration
FROM student s
INNER JOIN department d
ON s.dept_id=d.dept_id
INNER JOIN course c
ON s.course_id=c.course_id;
-- Display Student Table
SELECT * FROM student;
-- Search Student by Name
SELECT *
FROM student
WHERE student_name = 'Rahul';
-- Search Student by Department
SELECT *
FROM student
WHERE dept_id = 1;
-- Search Student by Course
SELECT *
FROM student
WHERE course_id = 1;
-- Create Index on Student Name
CREATE INDEX idx_student_name
ON student(student_name);
-- Show Indexes of Student Table
SHOW INDEX FROM student;
-- Search Student by Name After Index
SELECT *
FROM student
WHERE student_name = 'Rahul';
-- Create Index on Department Id
CREATE INDEX idx_department
ON student(dept_id);
-- Create Composite Index
CREATE INDEX idx_dept_course
ON student(dept_id, course_id);
-- Show Indexes Again
SHOW INDEX FROM student;
-- Explain Query
EXPLAIN
SELECT *
FROM student
WHERE student_name = 'Rahul';
-- Explain Query Using Department
EXPLAIN
SELECT *
FROM student
WHERE dept_id = 1;
-- Explain Query Using Composite Index
EXPLAIN
SELECT *
FROM student
WHERE dept_id = 1
AND course_id = 1;
-- Verify Indexes
SHOW INDEX FROM student;