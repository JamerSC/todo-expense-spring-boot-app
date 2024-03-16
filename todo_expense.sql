-- CREATE DATABASE todo_expense_db;
-- CREATE DATABASE IF NOT EXISTS todo_expense_db;
-- SHOW DATABASES;
-- USE todo_expense_db;
-- DROP TABLE User;
-- SHOW TABLES;
-- User table to store user information
CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- SELECT * FROM user;
-- TodoList table to store todo lists with a foreign key relationship to User

CREATE TABLE user_todos (
    todo_id INT AUTO_INCREMENT,
    todo_name VARCHAR(100) NOT NULL,
    todo_details VARCHAR(255) NOT NULL,
    user_id INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    PRIMARY KEY(todo_id)
);
# drop table user_todo;
# SELECT * FROM user_todos;

-- ExpenseTracker table to store expenses with a foreign key relationship to User
CREATE TABLE user_expenses (
    expense_id INT AUTO_INCREMENT,
    expense_name VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    user_id INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    PRIMARY KEY(expense_id)
);
# drop table user_expenses;
-- SELECT * FROM user_expenses;