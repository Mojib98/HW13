package repository;

import org.hibernate.SessionFactory;
import repository.imp.SessionFactorySingleton;

public class LoginRepository {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    public boolean employee(Integer id,Integer passcode){
        var session = sessionFactory.getCurrentSession();
        String hql = "select count(*) from Entity.Employee where  " +
                "EmployeeId = :id and passcode =: passcode";
        var query = session.createQuery(hql,Integer.class);
        query.setParameter("id",id);
        query.setParameter("passcode",passcode);
        Integer result = query.uniqueResult();
        if (result>=1){
            return true;
        }
        else {
            return false;
        }

    }
    public boolean student(Integer id,Integer passcode){
        var session = sessionFactory.getCurrentSession();
        String hql = "select count(*) from Entity.Student where  " +
                "idStudent = :id and passcode =: passcode";
        var query = session.createQuery(hql,Integer.class);
        query.setParameter("id",id);
        query.setParameter("passcode",passcode);
        Integer result = query.uniqueResult();
        if (result>=1){
            return true;
        }
        else {
            return false;
        }
    }
}
