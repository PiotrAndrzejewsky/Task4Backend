CREATE DATABASE task4;
USE task4;
CREATE TABLE users (
user_id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(50) NOT NULL,
last_login_time datetime DEFAULT NULL,
registration_time datetime DEFAULT CURRENT_TIMESTAMP,
active bit DEFAULT 1
);