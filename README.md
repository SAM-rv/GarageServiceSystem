# 🚗 Garage Service System

A Console-based **Garage Service Management System** built using **Core Java** and **JDBC** to connect with a **MySQL** database. This project manages customer vehicles, tracks service records, assigns mechanics, and generates billing.

## ✨ Features
* **User Authentication:** Role-based login (Admin, Mechanic, and Customer).
* **Service Management:** Track vehicle service status (Pending, In Progress, Completed).
* **Billing System:** Generate invoices for spare parts and labor.
* **Database Operations (CRUD):** Add, update, view, and delete records using JDBC.

## 🛠️ Prerequisites
Before you run this project, ensure you have the following installed:
* **Java Development Kit (JDK):** Version 11 or higher.
* **MySQL Server:** Version 8.0 or higher.
* **IDE:** IntelliJ IDEA, Eclipse, or NetBeans.
* **MySQL Connector/J:** The JDBC driver for Java.

## ⚙️ Setup and Installation

### 1. Clone the Repository
Open your terminal or Git Bash and run:
```bash
git clone https://github.com
cd garage-service-system
```

### 2. Database Setup
1. Open MySQL Workbench or your preferred MySQL client and run the following commands to create the database:
```sql
CREATE DATABASE garage_db;
USE garage_db;
```
2. Execute the provided `database_schema.sql` file (located in the root/database directory) to create the required tables.

### 3. Configure JDBC Connection
1. Open the project in your IDE.
2. Locate the database connection class (usually named `DatabaseConnection.java` or `DBUtil.java`).
3. Update the database URL, username, and password:
```java
private static final String URL = "jdbc:mysql://localhost:3306/garage_db";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
```

### 4. Add the MySQL JDBC Driver
Ensure that the `mysql-connector-j-x.x.x.jar` file is added to your IDE's project build path or dependencies.

### 5. Compile and Run
1. Compile the Java files in your IDE.
2. Run the main class (e.g., `Main.java` or `GarageSystem.java`).

## 📂 Project Structure
```text
Garage-Service-System/
│
├── src/
│   ├── dao/             # Data Access Objects (JDBC logic)
│   ├── model/           # POJO models (Vehicle, Customer, Mechanic)
│   ├── view/            # Console UI / Menus
│   └── database/        # SQL scripts (Schema & Dummy Data)
│
├── lib/                 # MySQL Connector JAR
├── README.md            # Project Documentation
└── database_schema.sql  # Database Schema
```

## 🤝 Contributing
Contributions are welcome! If you find any bugs or want to add new features, please fork the repository and create a pull request.
