package repository.imp;

import Entity.Course;
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
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.remove(sectionCourse);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }


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
    public Student findMyStudent(Integer id){
            Student student = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Student c " +
                    "where c.idStudent = :id";
            var q = session.createQuery(hql, Student.class);
         q.setParameter("id",this.id);
            student = q.uniqueResult();
        }
        return student;
    }
    private boolean checkerUnit(){
        Student student = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "select sum(c.unit) from Entity.SectionCourse c " +
                    "where c.student.idStudent = :id";
            var q = session.createQuery(hql,Integer.class);
            q.setParameter("id",this.id);
            var s = q.getSingleResult();
            if (s>=18){
                return false;
            }
            else
                return true;
        }

    }
    private boolean checkCourse(int id, Course course){
        try (var session = sessionFactory.openSession()) {
            String hql = "select c. from Entity.SectionCourse c " +
                    "where c.student.idStudent = :id";
            var q = session.createQuery(hql,Integer.class);
            q.setParameter("id",this.id);
            var s = q.getSingleResult();
            if (s>=18){
                return false;
            }
            else
                return true;
        }
    }
}
