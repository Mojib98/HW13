package service.impl;

import Entity.Course;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.imp.SessionFactorySingleton;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    static Course course;
    static CourseService courseService;
    static SessionFactory sessionFactory;

    @BeforeAll
     static void seting(){
         courseService = new CourseService();
         sessionFactory = SessionFactorySingleton.getInstance();
     }
     @BeforeEach
     void createCourse(){
         course = new Course(3, "math", null, "math1");
         try (var session = sessionFactory.getCurrentSession()) {
             var t = session.getTransaction();
             t.begin();
            session.save(course);
             t.commit();
         }

     }
     @AfterEach
     void removeCourse(){
         try (var session = sessionFactory.getCurrentSession()) {
             var t = session.getTransaction();
             t.begin();
             session.remove(course);
             t.commit();
         }
     }

    @Test
    void allCourse() {
        List<Course> list = null;
        list = courseService.allCourse();
        assertNotEquals(null,list);
    }

    @Test
    void findCourse() {
        Integer id = course.getId();
        Course course1 = courseService.findCourse(id);
        assertAll(
                () ->assertEquals(course1.getName(),course.getName()),
                () ->assertEquals(course1.getUnit(),course.getUnit()),
                () ->assertEquals(course1.getProfessor(),course.getProfessor())
        );
    }
}