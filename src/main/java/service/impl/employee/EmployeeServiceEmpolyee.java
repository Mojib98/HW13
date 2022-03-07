package service.impl.employee;

import Entity.Employee;
import repository.imp.EmployeeRepositoryEmployee;
import service.Service;

import java.util.List;
import java.util.Random;

public class EmployeeServiceEmpolyee implements Service<Employee> {
    EmployeeRepositoryEmployee employeeRepositoryEmployee = new EmployeeRepositoryEmployee();
    @Override
    public void add(Employee employee) {
        Random random = new Random();
        int id = random.ints(4, 1000, 1999).findFirst().getAsInt();
        employee.setEmployeeId(id);
        employeeRepositoryEmployee.add(employee);
    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
         return employeeRepositoryEmployee.findAll();

    }

    @Override
    public Employee showInformation(int id) {
        return null;
    }
}
