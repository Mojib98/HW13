package repository.imp;

import Entity.Course;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class CourseRepositoryEmployee implements Repository<Course> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    ProfessorRepositoryEmployee p = new ProfessorRepositoryEmployee();

    @Override
    public void add(Course course) {
        var session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void remove(Course course) {

    }

    //@Override
    public List<Course> findAll() {
        List<Course> list = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Course";
        var q = session.createQuery(hql, Course.class);
        list = q.getResultList();
        return list;
    }

    @Override
    public Course showInformation(int id) {
        Course course = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Course" +
                " where id=:id";
        var query = session.createQuery(hql, Course.class);
        query.setParameter("id",id);
        course = query.uniqueResult();
        return course;
    }
}
