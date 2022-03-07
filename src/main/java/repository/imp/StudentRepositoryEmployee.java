package repository.imp;

import Entity.Employee;
import Entity.Professor;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class StudentRepositoryEmployee implements Repository<Student> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public void add(Student student) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.save(student);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }

    @Override
    public void remove(Student student) {

    }

    @Override
    public List<Student> findAll() {
        List<Student> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee";
            var q = session.createQuery(hql, Student.class);
            list = q.getResultList();
        }
        return list;
    }

    @Override
    public Student showInformation(int id) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Student.class,id);

        }
    }
}
