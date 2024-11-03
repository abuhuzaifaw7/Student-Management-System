package service;

import entity.Student;

import java.util.List;

public interface StudentService {

    // CRUD --> Create , Read, Update, Delete

    // Create
    public Student createStudent(Student student);

    // Read
    public List<Student> getAllStudents();

    // Read
    public Student getStudentById(int id);

    // Update
    public Student updateStudent(int id , Student student);

    // Delete
    public boolean deleteStudent(int id);

}
