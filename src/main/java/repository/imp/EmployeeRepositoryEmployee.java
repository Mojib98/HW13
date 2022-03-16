package repository.imp;

import Entity.Employee;
import org.hibernate.SessionFactory;
import repository.Repository;

import java.util.List;

public class EmployeeRepositoryEmployee implements Repository<Employee> {
    SessionFactory sessionFactory;

    public EmployeeRepositoryEmployee() {
         sessionFactory = SessionFactorySingleton.getInstance();
    }
    @Override
    public void add(Employee employee) {
        var session = sessionFactory.getCurrentSession();
        session.save(employee);


    }

    @Override
    public void remove(Employee employee) {

    }

    //@Override
    public List<Employee> findAll() {
        List<Employee> list = null;
        var session = sessionFactory.getCurrentSession();
        String hql = "FROM Entity.Employee";
        var q = session.createQuery(hql, Employee.class);
        list = q.getResultList();
        return list;
    }
    @Override
    public Employee showInformation(int id) {
        Employee employee = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee " +
                    "where EmployeeId =:id";
            var q = session.createQuery(hql, Employee.class);
            q.setParameter("id",id);
            employee = q.uniqueResult();
        }
        return employee;
    }
}
