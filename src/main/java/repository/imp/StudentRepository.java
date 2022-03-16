package repository.imp;

import Entity.Course;
import Entity.SectionCourse;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class StudentRepository implements Repository<SectionCourse> {
    SessionFactory sessionFactory;
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentRepository(Integer id) {
        sessionFactory = SessionFactorySingleton.getInstance();
        this.id = id;
    }

    @Override
    public void add(SectionCourse sectionCourse) {
        var session = sessionFactory.getCurrentSession();
        session.save(sectionCourse);

    }

    @Override
    public void remove(SectionCourse sectionCourse) {
        var session = sessionFactory.getCurrentSession();
        session.remove(sectionCourse);
    }

    //@Override
    public List<SectionCourse> findAll() {
        List<SectionCourse> list = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.SectionCourse c " +
                "where c.student.idStudent = :id";
        var q = session.createQuery(hql, SectionCourse.class);
        q.setParameter("id", this.id);
        list = q.getResultList();
        return list;
    }

    @Override
    public SectionCourse showInformation(int id) {
        SectionCourse sectionCourse = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.SectionCourse c " +
                "where id = :id ";
        var q = session.createQuery(hql, SectionCourse.class);
        q.setParameter("id", id);
        return q.uniqueResult();
    }

    public Student findMyStudent(Integer id) {
        Student student = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Student c " +
                "where c.idStudent = :id ";
        var q = session.createQuery(hql, Student.class);
        q.setParameter("id", id);
        return q.uniqueResult();
        //  return  student;
    }

    public Long checkerUnit() {
        var session = sessionFactory.getCurrentSession();
        String hql = "select sum(c.unit) from Entity.SectionCourse c " +
                "where c.student.idStudent = :id";
        var q = session.createQuery(hql, Long.class);
        q.setParameter("id", this.id);
      //  System.out.println(s);
        var s = q.getSingleResult();
      //  System.out.println(s);
        return s;
    }


    public Integer checkCourse(Course course) {
        var session = sessionFactory.getCurrentSession();
        String hql = "select c.course.id from Entity.SectionCourse c " +
                "where c.student.idStudent = :id";
        var q = session.createQuery(hql, Integer.class);
        q.setParameter("id", this.id);
        var s = q.getSingleResult();
        System.out.println("s = " + s);
        // System.out.println(course.getId());

       return s;
    }
}

