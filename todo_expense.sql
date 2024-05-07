#CREATE DATABASE todo_expense_db;
#CREATE DATABASE IF NOT EXISTS todo_expense_db;
#SHOW DATABASES;
#USE todo_expense_db;
#DROP TABLE user;
#SHOW TABLES;
#User table to store user information

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
    gender ENUM('Male', 'Female', 'Other'),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_by INT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by INT NULL,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

#Note: DEFAULT 'Other': Sets the default value for the gender column to 'Other'.
#Note: AFTER lastName: Specifies the position of the new column relative to other columns in the table.
#ALTER TABLE user
#ADD COLUMN gender ENUM('Male', 'Female', 'Other') DEFAULT 'Other' AFTER last_name;

#ALTER TABLE todo_expense_db.user AUTO_INCREMENT=3000;
#TRUNCATE todo_expense_db.user;
#SELECT * FROM todo_expense_db.user;
#TodoList table to store todo lists with a foreign key relationship to User

CREATE TABLE todo (
    id INT AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    details VARCHAR(255) NOT NULL,
	start_date DATE,
    end_date DATE,
    status ENUM('Open', 'Ongoing', 'Pending', 'Completed'),
    created_by INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by INT,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES user(id),
    PRIMARY KEY(id)
);
#FOREIGN KEY (modified_by) REFERENCES user(user_id),
    
#Note: DEFAULT 'Other': Sets the default value for the gender column to 'Open'.
#Note: AFTER details: Specifies the position of the new column relative to other columns in the table.
#ALTER TABLE user_todos
#ADD COLUMN status ENUM('Open', 'Ongoing', 'Pending', 'Completed') DEFAULT 'Open' AFTER details;

#SELECT * FROM todo;

#ExpenseTracker table to store expenses with a foreign key relationship to User
CREATE TABLE expense (
    id INT AUTO_INCREMENT,
	date_of_payment DATE NOT NULL,
    item_description VARCHAR(255) NOT NULL,
	remarks VARCHAR(255), -- Added remarks field
    mode_of_payment ENUM ('Cash', 'Debit', 'Credit', 'Transfer', 'Mobile', 'Online', 'Prepaid'),
    amount DECIMAL(10, 2) NOT NULL,
	created_by INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	modified_by INT,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (created_by) REFERENCES user(id),
    PRIMARY KEY(id)
);
#FOREIGN KEY (modified_by) REFERENCES user(user_id),

#SELECT * FROM expense;

#drop table user;
#drop table todo;
#drop table expense;
#ALTER TABLE user DROP PRIMARY KEY;
