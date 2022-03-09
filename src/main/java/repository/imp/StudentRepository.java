package repository.imp;

import Entity.SectionCourse;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class StudentRepository implements Repository<SectionCourse> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void add(SectionCourse sectionCourse) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.save(sectionCourse);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }

    @Override
    public void remove(SectionCourse sectionCourse) {

    }

    @Override
    public List<SectionCourse> findAll() {
        List<SectionCourse> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.SectionCourse c " +
                    "where c.student.id = :id";
            var q = session.createQuery(hql, SectionCourse.class);
            session.setProperty("id",this.id);
            list = q.getResultList();
        }
        return list;
    }

    @Override
    public SectionCourse showInformation(int id) {
        return null;
    }
}
