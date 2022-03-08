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
        try {
            employeeRepositoryEmployee.add(employee);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("employee" + employee.getId()+" not adder");
        }
    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = null;
        try {
            list= employeeRepositoryEmployee.findAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not find");
        }
        return list;
    }

    @Override
    public Employee showInformation(int id) {
        Employee employee = null;
        try {
            employee = employeeRepositoryEmployee.showInformation(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User not find");
        }
        return employee;
    }

}

