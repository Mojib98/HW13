package service.impl;

import Entity.Course;
import org.hibernate.SessionFactory;
import repository.imp.CourseRepositoryEmployee;
import repository.imp.SessionFactorySingleton;
import service.Service;

import java.util.List;

public class CourseServiceEmployee implements Service<Course> {
    CourseRepositoryEmployee CRE;
    SessionFactory sessionFactory;

    public CourseServiceEmployee() {
        sessionFactory = SessionFactorySingleton.getInstance();
        CRE=new CourseRepositoryEmployee();
    }

    @Override
    public void add(Course course) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                CRE.add(course);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("wrong in adding Course");
                t.rollback();
            }
        }
    }

    @Override
    public void remove(Course course) {

    }

    //@Override
    public List<Course> findAll() {
        List<Course> courseList = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                courseList = CRE.findAll();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Not find");
                t.rollback();
            }
        }
        return courseList;
    }

    @Override
    public Course showInformation(int id) {
        Course course = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                course = CRE.showInformation(id);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Not find");
                t.rollback();
            }
        }
        return course;
    }
}
