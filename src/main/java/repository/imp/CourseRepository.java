package repository.imp;

import Entity.Course;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseRepository {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public List<Course> findAll(){
        List<Course> list = null;
       var session = sessionFactory.getCurrentSession();
            String hql = "FROM Entity.Course";
            var q = session.createQuery(hql, Course.class);
            list = q.getResultList();

        return list;

    }
    public Course findCourse(int id){
        var session = sessionFactory.getCurrentSession();
            return session.find(Course.class, id);



    }
}
