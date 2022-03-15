package service.impl;

import Entity.*;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.imp.SessionFactorySingleton;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    static SessionFactory sessionFactory;
    static StudentService studentService;
    CourseService courseService = new CourseService();
    Student student;
    Course course;
    @BeforeAll
    static void seting(){

        studentService = new StudentService(4001);
        sessionFactory = SessionFactorySingleton.getInstance();
    }
    @BeforeEach
    void createCourse(){
        student = new Student(4001,"majid",4001,"math",null);
         course = new Course(3,"math",null,"math2");
        course.setId(12);
        student.setIdStudent(4001);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            try {
                session.save(course);
                session.save(student);
                t.commit();
            }catch (Exception e){
                e.printStackTrace();
                t.rollback();
            }}}

    @Test
    void add() {
        studentService.add(course);
        Course course1 = courseService.findCourse(course.getId());
        assertEquals(course1.getId(),course.getId());
    }


    @Test
    void findAll() {
        List<SectionCourse> list=studentService.findAll();
        assertNotEquals(null,list);
    }
}