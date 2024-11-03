package dao;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// DAO CLASS
public class DataAccessObject {

    Connection connection = null;
    Statement statement = null;


    public DataAccessObject() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        props.setProperty("ssl", "false");
        try {

            connection = DriverManager.getConnection(url, props);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public void createConnection() {
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "postgres");
//        props.setProperty("ssl", "false");
//        try {
//
//            connection = DriverManager.getConnection(url, props);
//            statement = connection.createStatement();
//            System.out.println("Statement created successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    // ExecuteUpdate --> does not return anything
    public boolean createStudent(Student student) {
        if (statement == null) {
            System.err.println("Statement is null. Please ensure the connection is established.");
            return false;
        }
        int isSaved = -1;
        String insertQuery = "INSERT INTO STUDENT VALUES( " + student.getId() + " , '" + student.getName() + "' , '" + student.getAddress() + "' , '" + student.getPhNo() + "' ) ";

        try {
            isSaved = statement.executeUpdate(insertQuery);
            System.out.println("IsSaved >>>>>>> " + isSaved);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isSaved == 1) {
            return true;
        } else {
            return false;
        }
    }

    // ExecuteQuery --> Returns resultset
    public List<Student> getAllStudent() {
        String getAllStudentQuery = "select * from student";
        List<Student> studentList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(getAllStudentQuery);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAddress(rs.getString(3));
                student.setPhNo(rs.getString(4));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }


    public Student getStudentById(int id) {
        String getStudentByIdQuery = "select * from student where id = " + id;
        ResultSet rs = null;
        Student student = new Student();
        try {
            rs = statement.executeQuery(getStudentByIdQuery);
            while (rs.next()) {
                student.setId(rs.getInt(0));
                student.setName(rs.getString(1));
                student.setAddress(rs.getString(2));
                student.setPhNo(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // ExecuteUpdate
    public Student updateStudent(int id, Student student) {
        String updateQuery = " update student set name = " + student.getName() + " , " + " address = " + student.getAddress() + " , " + " phno = " + student.getPhNo() + " where id = " + id;


        int isUpdate = -1;
        try {
            isUpdate = statement.executeUpdate(updateQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isUpdate == 1) {
            return student;
        } else {
            throw new RuntimeException("Failed to update the student with ID : " + id);
        }
    }

    public boolean deleteStudent(int id) {
        String deleteQuery = " delete from student where id = " + id;
        int isDeleted = -1;
        try {
            isDeleted = statement.executeUpdate(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isDeleted == 1) {
            return true;
        } else {
            return false;
        }
    }
}
