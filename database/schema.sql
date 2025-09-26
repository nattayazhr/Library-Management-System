CREATE database LibraryManagementSystem;
USE LibraryManagementSystem;

-- Books Table
 CREATE TABLE books (
  book_id INT AUTO_INCREMENT PRIMARY KEY,
  book_title VARCHAR(200) NOT NULL,
  book_author VARCHAR(100) NOT NULL,
  book_price DECIMAL(8,2) NOT NULL
);

-- Users Table
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100) NOT NULL,
  email VARCHAR(254) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  role ENUM('USER','ADMIN') DEFAULT('USER')
);

-- book_transactions Table
CREATE TABLE book_transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    transaction_type ENUM('ISSUED', 'RETURNED') NOT NULL,
    transaction_date DATE NOT NULL DEFAULT(CURRENT_DATE),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);
