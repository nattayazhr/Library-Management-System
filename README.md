# Library Management System 📚

A **Java-based Library Management System** built using **JDBC, Servlets, JSP**, following the **MVC pattern**, and using **MySQL** for the database. The system allows **admin and user roles**, enabling users to search, issue, and return books while tracking transactions.

---

## 🌟 Features

### Admin
- Add, view, and remove books
- View all users and issued books
- Manage transactions (issue/return records)

### User
- Search for books
- Issue available books
- Return books
- View issued book history

### General
- Login system for admin and users
- MVC architecture ensures clean separation of concerns
- Connection pooling with **HikariCP** for efficient database connections

---

## 🛠️ Tech Stack
- **Backend:** Java, JDBC, Servlets  
- **Frontend:** JSP, HTML, CSS  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse  
- **Libraries:** HikariCP for database connection pooling  

---

## ⚡ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/RishiChamarthi/Library-Management-System.git
```

### 2. Import into Eclipse
```bash
Open Eclipse IDE → File → Import → Existing Projects into Workspace → Select the project folder.
```

### 3. Setup Database
Open MySQL Workbench (or any MySQL client).

```bash
Run the database → schema.sql file from this repo to create tables
Run the database → data.sql file from this repo to create the sample data
```

### 4. Configure Database Connection
```bash
Open src → main → webapp → WEB-INF → config → config.properties 
```
Update:

```bash
url = jdbc:mysql://localhost:3306/LibraryManagementSystem
user = root
password = your_mysql_password
```

### 5. Run on Tomcat
```bash
Right-click project → Run As → Run on Server → Apache Tomcat.

Access via: http://localhost:8080/LibraryManagementSystem/
```

## 📝 Database Schema (Summary)

- **users** → Stores user and admin credentials

- **books** → Stores book information 

- **book_transactions** → Stores issue and return records

## 🚀 Future Improvements

- Add search by category and pagination

- Add remove user option for Admin

- Enhance UI with Bootstrap/TailwindCSS

