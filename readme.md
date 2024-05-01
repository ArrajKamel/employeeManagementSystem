## Employee Management System Application Documentation

### Introduction

EMS app is a system designed for managing a company employees by the HR. this application has designed for each company
has an online employee system in which the HR can add, delete, update, display the employees , check who is online and 
who is not, and a lot of other features.

At the same time each employee can sign up and create a new account where they can check there personal information in 
case there is something wrong, setting up there activity (online or offline).

Logging in is possible in two ways:

* **HR** account where the owner of these accounts can manipulate and visualize the whole data.
* **Employee** accounts where the owner of these accounts can just see their own personal data without the ability to
modify it .


### Used Technology 

- **Framework**: Java Swing
- **Build Tool**: IntelliJ
- **Database**: MySQL

### Start the application

1. **Configuration**: Check `src/repo` for EmployeeRepo. Adjust the database *'URL'*, username *'dbusername'*, and
   password *'dbpassword'* as per your MySQL setup, and go to the file "Tool" adjust the path of this file according to yours.
2. **Database Setup**:  Install MySql server and import the database *'ems.sql'* to your MySQL localhost. do not forget to add *mysql-connection-j-8-2-0.jar'* to you project.
   If you are using IntelliJ Idea do the follow to add the file : navigate "File->Project Structure->modules-> + -> JARs or directory" select the file.
3. **Running the App**: Navigate to `src/main/Main.java` and run 'main()' method to start the application.

## Project Structure

The project adheres to the MVC architecture, organized into the following directories:

- `src` is the main folder in this project. Inside this folder there are :
    - `/controller` contains all controllers of the java app,
    - `/main` contains Main method and some classes.
    - `/view` contains all the views.
    - `/resourses` contains all the icons and *tool* class.
    - `/repo` contains *EmployeeRepo* which handles the whole operation with the database.
      

## The application supports CRUD operations 

- **Create**: Add new employee, in ManagementView -> addEmployeePanel -> addButton.
- **Read**: tables and refresh buttons, you can find it in ManagementView.
- **Update**: update the Employee data, in ManagementView -> addEmployeePanel -> updateButton, and some other places.
- **Delete**: Delete an Employee or an account, in ManagementView -> addEmployeePanel -> deleteButton, and some other places.

You can find the all CRUD operations in `src/repo/EmployeeRepo`.

Check the Requirements 

- ✅ Compilation (1p).
- ✅ MVC (1p) | (but in my project there was no needed to create Models).
- ✅❌ Inheritance (Override & Overload) (0.5p) | I have inheritance and a lot of override & Overload but all of them form JFrame so i do not know if they are considered or not.
- ❌ Enumerations (0.5p).
- ✅ Desktop Application (0.5p).
- ✅ Min 5 Views (1p) | LoginView , SignupView , EmployeeView , ManagementView(it has 4 integrated views).
- ✅ 2 Types of user (1p) | Employee and HR.
- ✅ Exception Handling (0.5p) .
- ✅ Code Style (1p) | Clear, understandable, organized project performed using *Camel Style*.
- ✅ Database Connection (1p) | uses MySQL server *localhost*.
- ✅ CRUD on entities (1p) | under user commands and in the background
- ✅ Documentation (1p) | Thank you for reading *all the best*.
