package repository.imp;

import Entity.Course;
import Entity.Employee;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class CourseRepositoryEmployee implements Repository<Course> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public void add(Course course) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.save(course);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public List<Course> findAll() {
        List<Course> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee";
            var q = session.createQuery(hql, Course.class);
            list = q.getResultList();
        }
        return list;
    }

    @Override
    public Course showInformation(int id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Course.class, id);

        }
    }
}
