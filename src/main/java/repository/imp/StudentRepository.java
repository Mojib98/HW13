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

    public StudentRepository(Integer id) {
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
            q.setParameter("id",this.id);
            list = q.list();
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
                    "where c.idStudent = :id ";
            var q = session.createQuery(hql, Student.class);
        q.setParameter("id",id);
            return q.uniqueResult();
          //  return  student;
        }
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
    public boolean checkCourse( Course course){
        try (var session = sessionFactory.openSession()) {
            String hql = "select c.course.id from Entity.SectionCourse c " +
                    "where c.student.idStudent = :id";
            var q = session.createQuery(hql,Integer.class);
            q.setParameter("id",this.id);
            var s = q.uniqueResult();
           // System.out.println("s = " + s);
           // System.out.println(course.getId());
            if (course.getId().equals(s)){
                return false;
            }
            else if (s ==null)
                return true;
        }
        return true;
    }
}
