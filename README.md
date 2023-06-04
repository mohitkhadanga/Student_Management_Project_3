# Student Management System

This is a Java-based Student Management System that allows administrators to perform various operations related to student records. The program provides functionality to add students, delete students, update student information, and view all students' details.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Author](#author)
- [Acknowledgments](#acknowledgments)

## Features
The Student Management System includes the following features:

- Add a new student to the system with their name, age, roll number, and marks.
- Delete a student from the system based on their roll number.
- Update student information such as name, age, roll number, or marks.
- View all students' details including their name, age, roll number, and marks.

## Prerequisites
To run this program on your local machine, ensure that you have the following prerequisites:

- Java Development Kit (JDK) installed
- Integrated Development Environment (IDE) or a command-line interface to compile and run Java programs
- MySQL database and JDBC driver (if using MySQL as the database)

## Technologies Used
The following technologies and concepts were used in developing this Student Management System:

- Core Java
- Object-Oriented Programming (OOPs) principles
- JDBC (Java Database Connectivity) for database operations
- Collection framework for storing and manipulating student data
- MySQL database for data storage (can be customized for other databases)

## Getting Started
To run this Student Management System on your local machine, follow these steps:

1. Clone the repository or download the source code files.
2. Import the project into your preferred IDE or navigate to the project directory in the command-line interface.
3. Set up the database connection by providing the appropriate credentials in the `DatabaseConnection` class.
4. Compile and run the `MainApp.java` file to start the Student Management System.

## Usage
Once the program is running, you will be prompted to sign in with administrator credentials. By default, the username is set to "admin" and the password is set to "admin123". You can modify the authentication logic in the `signIn()` method if needed.

After successful authentication, the program will display a menu with various options. Use the corresponding number to choose an option and follow the on-screen prompts to perform the desired operations such as adding a student, deleting a student, updating student information, or viewing all students' details.

## Author
- Name: Mohit Khadanga
- GitHub: https://github.com/mohitkhadanga

## Acknowledgments
This program was developed as a solo project.
