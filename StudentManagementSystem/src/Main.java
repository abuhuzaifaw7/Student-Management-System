import dao.DataAccessObject;
import entity.Student;
import serviceImpl.StudentServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataAccessObject dao = new DataAccessObject();
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean runLoop = true;
        while (runLoop) {
            System.out.println("Press 1 to create Student");
            System.out.println("Press 2 to Get All Students");
            System.out.println("Press 3 to Update Student");
            System.out.println("Press 4 to Get Student By ID");
            System.out.println("Press 5 to Delete Student");
            System.out.println("Press 6 to Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phno = scanner.nextLine();
                Student student = new Student(id, name, address, phno);
                System.out.println(student);
                studentServiceImpl.createStudent(student);

            } else if (choice == 2) {
                System.out.println(studentServiceImpl.getAllStudents());

            } else if (choice == 3) {

            } else if (choice == 4) {
                int id = scanner.nextInt();
                System.out.println(studentServiceImpl.getStudentById(id));

            } else if (choice == 5) {
                int id = scanner.nextInt();
                System.out.println(studentServiceImpl.deleteStudent(id));
            } else if (choice == 6) {
                runLoop = false;
            } else {
                System.out.println("Tameez se Application chala le !!!");
            }
        }
    }
}