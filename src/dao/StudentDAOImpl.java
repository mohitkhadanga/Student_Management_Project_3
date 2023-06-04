package dao;


import bean.Student;
import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            String sql = "INSERT INTO students (name, age, roll, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getRoll());
            statement.setDouble(4, student.getMarks());
            statement.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int roll) {
        try {
            String sql = "DELETE FROM students WHERE roll = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roll);
            statement.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(int roll, String property, String newValue) {
        try {
            String sql = "UPDATE students SET " + property + " = ? WHERE roll = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newValue);
            statement.setInt(2, roll);
            statement.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setRoll(resultSet.getInt("roll"));
                student.setMarks(resultSet.getDouble("marks"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

