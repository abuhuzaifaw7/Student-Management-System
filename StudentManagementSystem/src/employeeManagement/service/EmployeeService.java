package employeeManagement.service;
import employeeManagement.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    /* CRUD --> Create , Read, Update, Delete */

    /*  Create */
    public Employee createEmployee(Employee employee);


    /* Read */
    public List<Employee> getAllEmployee();


    /* read employee by id */
    public Employee getEmployeeById(int empId);

    // update
    public Employee updateEmployee(int empId, Employee employee);

    // Delete
    public boolean deleteEmployee(int empId);
}
