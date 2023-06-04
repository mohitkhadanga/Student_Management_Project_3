package main;

import bean.Student;
import dao.StudentDAO;
import dao.StudentDAOImpl;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAOImpl();

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management System!");

        if (signIn()) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Delete Student");
                System.out.println("3. Update Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        viewAllStudents();
                        break;
                    case 5:
                        System.out.println("Thank you for using the Student Management System. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private static boolean signIn() {
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        // Perform authentication logic here
        // You can compare the provided username and password with a pre-defined admin credentials

        return username.equals("admin") && password.equals("admin123");
    }

    private static void addStudent() {
        Student student = new Student();
        System.out.print("Enter name: ");
        student.setName(scanner.next());
        System.out.print("Enter age: ");
        student.setAge(scanner.nextInt());
        System.out.print("Enter roll: ");
        student.setRoll(scanner.nextInt());
        System.out.print("Enter marks: ");
        student.setMarks(scanner.nextDouble());

        studentDAO.addStudent(student);
    }

    private static void deleteStudent() {
        System.out.print("Enter the roll of the student to delete: ");
        int roll = scanner.nextInt();

        studentDAO.deleteStudent(roll);
    }

    private static void updateStudent() {
        System.out.print("Enter the roll of the student to update: ");
        int roll = scanner.nextInt();
        System.out.print("Enter the property to update (name, age, roll, marks): ");
        String property = scanner.next();
        System.out.print("Enter the new value: ");
        String newValue = scanner.next();

        studentDAO.updateStudent(roll, property, newValue);
    }

    private static void viewAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nAll Students:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Roll: " + student.getRoll());
                System.out.println("Marks: " + student.getMarks());
                System.out.println("--------------------");
            }
        }
    }

}

