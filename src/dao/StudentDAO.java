package dao;

import bean.Student;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void deleteStudent(int roll);
    void updateStudent(int roll, String property, String newValue);
    List<Student> getAllStudents();
}
