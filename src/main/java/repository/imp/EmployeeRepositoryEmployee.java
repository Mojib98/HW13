package repository.imp;

import Entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repository.Repository;

import java.util.List;

public class EmployeeRepositoryEmployee implements Repository<Employee> {
    public EmployeeRepositoryEmployee() {
    }

    SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    @Override
    public void add(Employee employee) {
        try (var session = sessionFactory.openSession()) {
            var t = session.getTransaction();
            try {
                session.save(employee);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }

    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = null;
        try (var session = sessionFactory.openSession()) {
            String hql = "FROM Entity.Employee";
           var q = session.createQuery(hql, Employee.class);
            list = q.getResultList();
        }
        return list;
    }
    @Override
    public Employee showInformation(int id) {
        try (var session = sessionFactory.openSession()) {
               return session.find(Employee.class,id);

        }
    }
}
