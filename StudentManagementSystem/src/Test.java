import entity.Student;

import java.sql.*;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        props.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(url, props);
        Statement statement = connection.createStatement();
        ResultSet rs =  statement.executeQuery("select * from student");
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setAddress(rs.getString(3));
            student.setPhNo(rs.getString(4));
            System.out.println(student);
        }
        connection.close();
    }
}
