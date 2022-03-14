package repository.imp;

import Entity.Professor;
import Entity.SectionCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProfessRepository {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
//    Session session = sessionFactory.getCurrentSession();
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void insertScore(int ids, Integer score){
        Session session = sessionFactory.getCurrentSession();
       // var t =session.getTransaction();
      //   t.begin();
        String hql=" update SectionCourse set score = :score " +
                "where id = :st" ;
       var a= session.createQuery(hql);
        a.setParameter("st",ids);
        a.setParameter("score",score);
         a.executeUpdate();
       // System.out.println(w);
       // t.commit();

         }
    public List<SectionCourse> myStudent(){
        var session = sessionFactory.getCurrentSession();
        String hql = " from Entity.SectionCourse e where e.professor.EmployeeId =2517" ;
        System.out.println("df");
        var s =session.createQuery(hql,SectionCourse.class);
        System.out.println(s.list()+" 1");
      return s.getResultList();
    }

    public Long myUnit(){
        Session session = sessionFactory.getCurrentSession();
        String hql = " select sum(e.unit) from Entity.SectionCourse e" +
                " where e.professor.EmployeeId =: id" ;
        var s =session.createQuery(hql,Long.class);
        s.setParameter("id",this.id);
        return s.getSingleResult();
    }
    public Professor myInfo(){
        Session session = sessionFactory.getCurrentSession();
        String hql = " from Entity.Professor e" +
                " where e.EmployeeId =: id" ;
        var s =session.createQuery(hql,Professor.class);
        s.setParameter("id",this.id);
        return s.uniqueResult();

    }



}





