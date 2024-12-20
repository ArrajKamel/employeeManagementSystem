# Employee Management System (EMS) Application

## Introduction
The **Employee Management System (EMS)** is a desktop application designed for HR departments to manage company employees efficiently. The application allows HR personnel to add, delete, update, and display employee information, track online/offline status, and access various other features. Employees can create accounts to view and verify their personal information or update their online status.

**User Types:**
- **HR Accounts**: Full access to manage and view all employee data.
- **Employee Accounts**: Limited access to view only personal data.

## Features
- **User Authentication**: Separate login for HR and employees.
- **CRUD Operations**:
  - **Create**: Add new employees.
  - **Read**: Display employee data.
  - **Update**: Modify existing employee information.
  - **Delete**: Remove employees or accounts.
- **Activity Tracking**: Monitor online/offline status of employees.

## Technologies Used
- **Language**: Java
- **Framework**: Java Swing
- **Build Tool**: IntelliJ IDEA
- **Database**: MySQL

## Manual Implementation
This project is implemented without the use of any external frameworks to demonstrate a deep understanding of core Java concepts and JDBC for database management. All functionalities, including CRUD operations and database interactions, are handled manually to showcase the developer's expertise in Java programming and database connectivity.

## Setup Instructions

### 1. Configuration
- Open the `src/repo/EmployeeRepo` file.
- Adjust the database connection parameters:
  - **Database URL**
  - **Username** (`dbusername`)
  - **Password** (`dbpassword`)
- Update the file path in the "Tool" class according to your local setup.

### 2. Database Setup
1. Install MySQL server.
2. Import the `ems.sql` database file to your MySQL localhost.
3. Add the MySQL JDBC driver (`mysql-connection-j-8-2-0.jar`) to the project:
   - In IntelliJ IDEA: Navigate to `File > Project Structure > Modules > + > JARs or Directory` and select the JAR file.

### 3. Running the Application
- Navigate to `src/main/Main.java`.
- Run the `main()` method to start the application.

## Project Structure
The application follows the **Model-View-Controller (MVC)** architecture:
- `src`: Main project folder containing the following subdirectories:
  - **`/controller`**: Controllers handling application logic.
  - **`/main`**: Main method and supporting classes.
  - **`/view`**: All application views.
  - **`/resources`**: Icons and the "Tool" class.
  - **`/repo`**: `EmployeeRepo` class managing database operations.

## Key Functional Requirements
- **Compilation**: The project compiles and runs successfully.
- **MVC Architecture**: The application is organized using the MVC pattern for better scalability and maintainability.
  - Note: Models were not explicitly necessary for this project.
- **Manual Implementation**: All features and database interactions are implemented without frameworks, showcasing a strong understanding of Java and JDBC.
- **Inheritance and Polymorphism**: The project uses inheritance and method overriding/overloading effectively (primarily within `JFrame` components).
- **Enumerations**: Not implemented; considered unnecessary for the current scope.
- **Desktop Application**: Fully functional Java Swing-based desktop application.
- **Multiple Views**: The application provides at least five views:
  - `LoginView`, `SignupView`, `EmployeeView`, `ManagementView` (with four integrated subviews).
- **Role-Based Access**: Two distinct user types (HR and Employee) with role-specific access controls.
- **Exception Handling**: Comprehensive exception handling for robust error management.
- **Code Style**: Adheres to industry standards with clear, maintainable, and camelCase naming conventions.
- **Database Integration**: Seamless integration with MySQL for data storage and retrieval.
- **CRUD Operations**: Fully implemented for managing employee records:
  - **Create**: Add new employees.
  - **Read**: View employee data.
  - **Update**: Edit employee information.
  - **Delete**: Remove employees/accounts.

## Notes
- **Inheritance**: While inheritance and method overriding/overloading are implemented, they mainly involve `JFrame` components.
- **Enumerations**: Excluded from the project as they were not necessary for the defined requirements.

Thank you for reviewing this documentation. If you have any questions or need further clarification, feel free to reach out!
