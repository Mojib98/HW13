package repository.imp;
import Entity.Employee;
import Entity.Professor;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class ProfessorRepositoryEmployee implements Repository<Professor> {
    SessionFactory sessionFactory;

    public ProfessorRepositoryEmployee() {
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    @Override
    public void add(Professor professor) {
       var session = sessionFactory.getCurrentSession();
                session.save(professor);


    }

    @Override
    public void remove(Professor professor) {

    }

    //@Override
    public List<Employee> findAll() {
        List<Employee> list = null;
        var session = sessionFactory.getCurrentSession();
            String hql = "FROM Entity.Professor";
            var q = session.createQuery(hql);
            list = q.getResultList();

        return list;
    }

    @Override
    public Professor showInformation(int id) {
        var session = sessionFactory.getCurrentSession();
            String hql = "from Entity.Professor p " +
                    "where p.EmployeeId =:id " ;
           var s= session.createQuery(hql,Professor.class);
          var d=  s.setParameter("id",id);
            return d.getSingleResult();
        }

}
