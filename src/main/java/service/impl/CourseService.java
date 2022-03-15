package service.impl;

import Entity.Course;
import Entity.Professor;
import org.hibernate.SessionFactory;
import repository.imp.CourseRepository;
import repository.imp.SessionFactorySingleton;

import java.util.List;

public class CourseService {
    CourseRepository courseRepository ;
    SessionFactory sessionFactory;

    public CourseService() {
        sessionFactory = SessionFactorySingleton.getInstance();
        courseRepository = new CourseRepository();
    }

    public List<Course> allCourse(){
        List<Course> list = null;
        try (var session = sessionFactory.getCurrentSession()) {
           var t= session.getTransaction();
           t.begin();
           list = courseRepository.findAll();
           t.commit();
        return list;
    }}
    public Course findCourse(int id) {
        List<Course> list = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            t.begin();
            return courseRepository.findCourse(id);
        }
    }
}
