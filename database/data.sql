-- books_data
INSERT INTO books (book_title, book_author, book_price) VALUES
('The God of Small Things', 'Arundhati Roy', 350.00),
('Malgudi Days', 'R.K. Narayan', 250.00),
('The White Tiger', 'Aravind Adiga', 310.00),
('Gitanjali', 'Rabindranath Tagore', 200.00),
('The Inheritance of Loss', 'Kiran Desai', 360.00),
('Midnight\'s Children', 'Salman Rushdie', 420.00),
('The Inheritance of Loss', 'Kiran Desai', 360.00),
('Interpreter of Maladies', 'Jhumpa Lahiri', 340.00),
('A Suitable Boy', 'Vikram Seth', 500.00),
('The Palace of Illusions', 'Chitra Banerjee Divakaruni', 330.00),
('Five Point Someone', 'Chetan Bhagat', 220.00),
('The Guide', 'R.K. Narayan', 270.00),
('Sea of Poppies', 'Amitav Ghosh', 390.00),
('The Shadow Lines', 'Amitav Ghosh', 370.00),
('Serious Men', 'Manu Joseph', 320.00),
('The Immortals of Meluha', 'Amish Tripathi', 280.00),
('Chanakya\'s Chant', 'Ashwin Sanghi', 300.00),
('An Era of Darkness', 'Shashi Tharoor', 450.00),
('The Discovery of India', 'Jawaharlal Nehru', 400.00),
('Wings of Fire', 'A.P.J. Abdul Kalam', 250.00),
('I Have a Dream', 'Rashmi Bansal', 230.00),
('The Lowland', 'Jhumpa Lahiri', 360.00),
('The Hungry Tide', 'Amitav Ghosh', 380.00),
('India After Gandhi', 'Ramachandra Guha', 480.00),
('The Great Indian Novel', 'Shashi Tharoor', 350.00);

-- users data
-- Admin -> password -> admin@123 (sample admin)
-- User -> password -> ram@123 (sample user)
INSERT INTO users(user_name, email, password_hash, role) VALUES
('Admin', 'admin@library.com', '7676aaafb027c825bd9abab78b234070e702752f625b752e55e55b48e607e358', 'ADMIN'),
('Ram', 'ram@gmail.com', 'a6b9d35a49b08e3fac7b55c40d82c9e94d3c95372a311a6e514fecfd8d25f12c', 'USER');

-- book_transaction data
insert into book_transactions(book_id, user_id, transaction_type, transaction_date) values
(5,	2, 'ISSUED', '2025-09-19'),
(5,	2, 'RETURNED', '2025-09-19'),
(7, 2, 'ISSUED', '2025-09-19'),
(10, 2, 'ISSUED', '2025-09-19'),
(10, 2, 'RETURNED', '2025-09-19'),
(7,	2, 'RETURNED', '2025-09-19'),
(8, 2, 'ISSUED', '2025-09-19'),
(8,	2, 'RETURNED', '2025-09-19'),
(12, 2, 'ISSUED', '2025-09-19'),
(11, 2, 'ISSUED', '2025-09-19'),
(12, 2, 'RETURNED', '2025-09-19'),
(11, 2, 'RETURNED', '2025-09-19'),
(20, 3, 'ISSUED', '2025-09-19'),
(20, 2, 'RETURNED', '2025-09-19');
