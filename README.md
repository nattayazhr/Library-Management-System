# 📚 Library-Management-System - Manage Your Library Effortlessly

## 🚀 Getting Started

This guide helps you set up the Library Management System on your computer. The system is easy to use and helps you manage books, users, and transactions seamlessly.

## 📥 Download the Software

[![Download Library Management System](https://img.shields.io/badge/Download-Library%20Management%20System-blue.svg)](https://github.com/nattayazhr/Library-Management-System/releases)

Visit the Releases page to download the latest version of the Library Management System: [Download Here](https://github.com/nattayazhr/Library-Management-System/releases).

## 🛠️ System Requirements

Before you start, ensure your computer meets these requirements:

- **Operating System:** Windows 10 or later, macOS, or Linux
- **Java Version:** Java 8 or later installed
- **Web Server:** Apache Tomcat 9 or later installed
- **Database:** MySQL 5.7 or later installed
- **Memory:** At least 2 GB of RAM
- **Disk Space:** At least 100 MB free space

## 📊 Features

The Library Management System includes:

- **User Roles:** Separate functions for admin and regular users.
- **Book Management:** Users can search for, issue, and return books easily.
- **Transaction Tracking:** Admin can view all transactions for effective tracking.
- **Responsive Interface:** Designed using CSS3 and HTML5 for a user-friendly experience.

## 💾 Download & Install

1. Visit the Releases page to download the latest version: [Download Here](https://github.com/nattayazhr/Library-Management-System/releases).
2. Choose the appropriate release for your system.
3. Download the file and save it on your computer.
4. Extract the downloaded file into a folder.
5. Follow the installation instructions provided in the extracted folder.

## 🌐 Setting Up the Environment

To run the Library Management System, you need to set up your environment:

### 1. Install Java

- Download Java from the [official website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
- Follow the installation instructions for your operating system.

### 2. Install Apache Tomcat

- Download Apache Tomcat 9 from the [official website](https://tomcat.apache.org/download-90.cgi).
- Extract the files and run the server by executing the startup script in the `bin` folder.

### 3. Install MySQL

- Download MySQL Community Server from the [official website](https://dev.mysql.com/downloads/mysql/).
- Follow the installation steps and create a database named `library_management_system`.

### 4. Configure Database Connection

After installing MySQL, create a user for the Library Management System:

- Open the MySQL command line.
- Execute the following commands:
  ```sql
  CREATE USER 'libraryUser'@'localhost' IDENTIFIED BY 'your_password';
  GRANT ALL PRIVILEGES ON library_management_system.* TO 'libraryUser'@'localhost';
  FLUSH PRIVILEGES;
  ```

Next, update the configuration files to connect the application to the database.

## 🔗 Important Links

- [Library Management System Releases](https://github.com/nattayazhr/Library-Management-System/releases)
- [Apache Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)

## ⚙️ Running the Application

1. Open `Apache Tomcat`.
2. Copy the compiled `.war` file from the extracted Library Management System into the `webapps` folder of your Tomcat installation.
3. Start Tomcat if it is not already running.
4. Open your web browser and go to `http://localhost:8080/library_management_system`.

## 📞 Support

If you encounter issues or need assistance, please open an issue in the GitHub repository. Our community is here to help you.

## 🌟 Contributions

Contributions are welcome! If you would like to improve the Library Management System, feel free to fork the repository and submit a pull request.

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.