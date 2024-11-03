package employeeManagement.dao;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataAccessObject {
    /* DAO Class */

    Connection connection = null;
    Statement statement = null;

    public void createConnection(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";

        try{
            connection = DriverManager.getConnection(url,  username, password);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // ExecuteUpdate --> does not return anything
//    public boolean createEmployee(Student student){
//        boolean isSaved = -1;
//        String insertQuery = "INSERT INTO EMPLOYEE VALUE"
//
//    }
}
