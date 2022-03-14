package repository.imp;

import Entity.Employee;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryEmployeeTest {
    static SessionFactory sessionFactory;
   static EmployeeRepositoryEmployee employeeRepositoryEmployee;
   Employee employee;
    @BeforeAll
    static void setConnection(){
    sessionFactory = SessionFactorySingleton.getInstance();
        employeeRepositoryEmployee=new EmployeeRepositoryEmployee();
    }
    @BeforeEach
    void adding(){
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }
    @AfterEach
    void deleting(){
        try (var session = sessionFactory.openSession()) {
                    var transaction = session.beginTransaction();
            try {
                session.delete(employee);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
    }}

    @Test
    void add() {
    }

    @Test
    void findAll() {
    }

    @Test
    void showInformation() {
    }
}