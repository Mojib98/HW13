package repository.imp;

import Entity.Course;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseRepository {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public List<Course> findAll(){
        List<Course> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee";
            var q = session.createQuery(hql, Course.class);
            list = q.getResultList();
        }
        return list;

    }
    public Course findCourse(int id){
        try (var session = sessionFactory.openSession()) {
            return session.find(Course.class, id);

        }

    }
}
