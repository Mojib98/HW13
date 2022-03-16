package repository.imp;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.Repository;
import java.util.List;

public class StudentRepositoryEmployee implements Repository<Student> {
    SessionFactory sessionFactory;

    public StudentRepositoryEmployee() {
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    @Override
    public void add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);

    }

    @Override
    public void remove(Student student) {

    }

    //@Override
    public List<Student> findAll() {
        List<Student> list = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Student";
        var q = session.createQuery(hql, Student.class);
        list = q.getResultList();
        return list;
    }

    @Override
    public Student showInformation(int id) {
        Student student = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Student " +
                "where idStudent =: id";
        var q = session.createQuery(hql, Student.class);
        q.setParameter("id",id);
        student = q.uniqueResult();
        return student;
    }


}
