-- 1. CREATE DATABASE

CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- 2. CREATE TABLES

CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(100),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    joined_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. INSERT DATA (DML)

INSERT INTO patients
(first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES
('Ramesh', 'Kumar', '1979-05-14', 'Male', '9876543210', 'ramesh@email.com'),
('Sita', 'Sharma', '1990-08-21', 'Female', '9876543211', 'sita@email.com'),
('Aman', 'Verma', '2001-01-30', 'Male', '9876543212', 'aman@email.com');

INSERT INTO doctors
(first_name, last_name, specialization, phone_number, email)
VALUES
('Anjali', 'Rao', 'Cardiology', '9123456780', 'dr.rao@clinic.com'),
('Vikram', 'Iyer', 'Pediatrics', '9123456781', 'dr.iyer@clinic.com');

-- 4. SELECT DATA

SELECT * FROM patients;
SELECT * FROM doctors;

-- 5. ALTER TABLE (DDL)

-- Add a new column
ALTER TABLE patients
ADD COLUMN address VARCHAR(200);

-- View structure
DESCRIBE patients;

-- Modify datatype
ALTER TABLE patients
MODIFY COLUMN phone_number VARCHAR(20);

-- Rename column
ALTER TABLE patients
CHANGE COLUMN address home_address VARCHAR(200);

-- Drop column
ALTER TABLE patients
DROP COLUMN home_address;

-- 6. UPDATE (DML)

UPDATE patients
SET phone_number = '9998887777'
WHERE patient_id = 1;

SELECT * FROM patients;

-- 7. DELETE (DML)

DELETE FROM patients
WHERE patient_id = 3;

SELECT * FROM patients;

-- 8. TCL (TRANSACTION CONTROL LANGUAGE)

START TRANSACTION;

UPDATE patients
SET phone_number = '1112223333'
WHERE patient_id = 1;

DELETE FROM patients
WHERE patient_id = 99;

-- Undo changes
ROLLBACK;

SELECT * FROM patients;

-- ------------------------------------------

START TRANSACTION;

UPDATE patients
SET phone_number = '8888888888'
WHERE patient_id = 2;

COMMIT;

SELECT * FROM patients;

-- 9. SAVEPOINT

START TRANSACTION;

UPDATE patients
SET first_name = 'Rajesh'
WHERE patient_id = 1;

SAVEPOINT sp1;

UPDATE patients
SET last_name = 'Singh'
WHERE patient_id = 1;

ROLLBACK TO sp1;

COMMIT;

SELECT * FROM patients;

-- 10. RENAME TABLE (DDL)

RENAME TABLE patients TO clinic_patients;

SHOW TABLES;

RENAME TABLE clinic_patients TO patients;

SHOW TABLES;

-- 11. TRUNCATE TABLE (DDL)

TRUNCATE TABLE doctors;

-- 12. DROP TABLE (DDL)


DROP TABLE doctors;

-- 13. DCL (DATA CONTROL LANGUAGE)

-- Create a user (MySQL 8+)

CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost'
IDENTIFIED BY 'Clinic@123';

-- Grant privileges

GRANT SELECT, INSERT
ON health_clinic_db.*
TO 'clinic_app_user'@'localhost';

-- Check grants

SHOW GRANTS FOR 'clinic_app_user'@'localhost';

-- Revoke privilege

REVOKE INSERT
ON health_clinic_db.*
FROM 'clinic_app_user'@'localhost';

SHOW GRANTS FOR 'clinic_app_user'@'localhost';

-- 14. DROP DATABASE (Optional)

DROP DATABASE health_clinic_db;