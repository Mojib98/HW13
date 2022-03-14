package service.impl;

import Entity.Employee;
import Entity.Professor;
import org.hibernate.SessionFactory;
import repository.imp.ProfessorRepositoryEmployee;
import repository.imp.SessionFactorySingleton;
import service.Service;

import java.util.List;
import java.util.Random;

public class ProfessorServiceEmployee implements Service<Professor> {
    ProfessorRepositoryEmployee professorRepositoryEmployee;
    SessionFactory sessionFactory ;

    public ProfessorServiceEmployee() {
        professorRepositoryEmployee = new ProfessorRepositoryEmployee();
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    @Override
    public void add(Professor professor) {
        Random random = new Random();
        int id = random.ints(4, 2000, 3000).findFirst().getAsInt();
        professor.setEmployeeId(id);
        professor.setPasscode(id);

        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                professorRepositoryEmployee.add(professor);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("professor not added");
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
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
             list=   professorRepositoryEmployee.findAll();
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" not find");
                t.rollback();
            }
        }
        return list;
    }

    @Override
    public Professor showInformation(int id) {
        Professor professor = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                professor= professorRepositoryEmployee.showInformation(id);
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("User not find");
                t.rollback();
            }
        }
        return professor;
    }
}
