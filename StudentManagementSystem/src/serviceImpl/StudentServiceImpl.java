package serviceImpl;

import dao.DataAccessObject;
import entity.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
// Business Logic

    DataAccessObject dao = new DataAccessObject();


    @Override
    public Student createStudent(Student student) {
        boolean isSaved = dao.createStudent(student);
        if (isSaved) {
            return student;
        } else {
            throw new RuntimeException("Failed to save student with ID : " + student.getId());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return dao.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) {
        return dao.getStudentById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return dao.updateStudent(id, student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return dao.deleteStudent(id);
    }
}
