package repository.imp;

import Entity.Employee;
import Entity.Professor;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class ProfessorRepositoryEmployee implements Repository<Professor> {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public void add(Professor professor) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.save(professor);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }

    }

    @Override
    public void remove(Professor professor) {

    }

    @Override
    public List<Professor> findAll() {
        List<Professor> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee";
            var q = session.createQuery(hql, Professor.class);
            list = q.getResultList();
        }
        return list;
    }

    @Override
    public Professor showInformation(int id) {
        try (var session = sessionFactory.openSession()) {
            String hql = "from Entity.Professor p " +
                    "where p.EmployeeId =:id " ;
           var s= session.createQuery(hql,Professor.class);
          var d=  s.setParameter("id",id);
            return d.getSingleResult();
        }
    }
}
