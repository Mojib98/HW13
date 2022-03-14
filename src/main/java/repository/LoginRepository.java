package repository;

import Entity.Employee;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.imp.SessionFactorySingleton;

public class LoginRepository {
    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    public boolean employee(Integer id,Integer passcode){
        var session = sessionFactory.getCurrentSession();
        String hql = "  from Entity.Employee where  " +
                "EmployeeId = :id and passcode =: passcode";
        var query = session.createQuery(hql, Employee.class);
        query.setParameter("id",id);
        query.setParameter("passcode",passcode);
        Employee result = query.uniqueResult();
        System.out.println(result);
        if (result != null){
            return true;
        }
        else {
            return false;
        }

    }
    public boolean student(Integer id,Integer passcode){
        var session = sessionFactory.getCurrentSession();
        String hql = " from Entity.Student where  " +
                "idStudent = :id and passcode =: passcode";
        var query = session.createQuery(hql, Student.class);
        query.setParameter("id",id);
        query.setParameter("passcode",passcode);
        Student result = query.uniqueResult();
        if (result !=null){
            return true;
        }
        else {
            return false;
        }
    }
}
