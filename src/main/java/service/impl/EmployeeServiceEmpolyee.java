package service.impl;

import Entity.Employee;
import org.hibernate.SessionFactory;
import repository.imp.EmployeeRepositoryEmployee;
import repository.imp.SessionFactorySingleton;
import service.Service;

import java.util.List;
import java.util.Random;

public class EmployeeServiceEmpolyee implements Service<Employee> {
    EmployeeRepositoryEmployee employeeRepositoryEmployee;
    SessionFactory sessionFactory;
    public EmployeeServiceEmpolyee() {
        sessionFactory = SessionFactorySingleton.getInstance();
        employeeRepositoryEmployee = new EmployeeRepositoryEmployee();

    }
    @Override
    public void add(Employee employee) {
        Random random = new Random();
        int id = random.ints(4, 1000, 1999).findFirst().getAsInt();
        employee.setEmployeeId(id);
        employee.setPasscode(id);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                employeeRepositoryEmployee.add(employee);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("employee" + employee.getId() + " not adder");
            }
        }

    }

    @Override
    public void remove(Employee employee) {

    }

    //@Override
    public List<Employee> findAll() {
        List<Employee> list = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                list = employeeRepositoryEmployee.findAll();
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("Not find");
            }
        }
        return list;
    }

    @Override
    public Employee showInformation(int id) {
        Employee employee = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                employee = employeeRepositoryEmployee.showInformation(id);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("Not find");
            }
        }
        return employee;
    }

}

