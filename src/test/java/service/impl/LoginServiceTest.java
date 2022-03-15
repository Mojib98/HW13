package service.impl;

import Entity.Course;
import Entity.Employee;
import Entity.Professor;
import Entity.Student;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.imp.SessionFactorySingleton;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    Professor professor;
    Employee employee;
    Student student;
    static LoginService loginService;
    static SessionFactory sessionFactory;

    @BeforeAll
    static void seting(){
        loginService = new LoginService();
        sessionFactory = SessionFactorySingleton.getInstance();
    }
    @BeforeEach
    void createCourse(){
        professor = new Professor(2001,"majid",2001,"ft",2001,null,"math");
        employee = new Employee(1998,"majid",1998,"Active",1998);
        student = new Student(4001,"majid",4001,"math",null);
        student.setIdStudent(4001);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
            session.save(professor);
            session.save(employee);
            session.save(student);
            t.commit();
        }catch (Exception e){
                e.printStackTrace();
                t.rollback();
            }}

    }
    @AfterEach
    void removeCourse(){
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
            session.remove(student);
            session.remove(professor);
            session.remove(employee);
            t.commit();
        }catch (Exception e){
                e.printStackTrace();
                t.rollback();
            }
        }
    }


    @Test
    void checking() {
       boolean check1= loginService.checking(employee.getEmployeeId(),employee.getPasscode());
       boolean check2= loginService.checking(professor.getEmployeeId(),professor.getPasscode());
       boolean check3= loginService.checking(student.getIdStudent(),student.getPasscode());
       boolean check4= loginService.checking(4002,2);
       boolean check5= loginService.checking(4033,3);
       assertAll(
               () ->assertTrue(check1),
               () ->assertTrue(check2),
               () ->assertTrue(check3),
               () ->assertFalse(check4),
               () ->assertFalse(check5)
       );
    }
}