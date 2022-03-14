package service.impl;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.imp.SessionFactorySingleton;
import repository.imp.StudentRepositoryEmployee;
import service.Service;
import java.util.List;
import java.util.Random;

public class StudentServiceEmployee implements Service<Student> {
    StudentRepositoryEmployee sRC;
    SessionFactory sessionFactory;

    public StudentServiceEmployee() {
        sessionFactory = SessionFactorySingleton.getInstance();
        sRC=new StudentRepositoryEmployee();
    }

    @Override
    public void add(Student student) {
        Random random = new Random();
        int id = random.ints(4, 4000, 6000).findFirst().getAsInt();
        student.setIdStudent(id);
        student.setPasscode(id);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                sRC.add(student);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("not to add");
            }
        }
    }

    @Override
    public void remove(Student student) {

    }

    @Override
    public List<Student> findAll() {
        List<Student> list = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
               list = sRC.findAll();
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("not to add");
            }
        }



        return list;
    }

    @Override
    public Student showInformation(int id) {
        Student student = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                student = sRC.showInformation(id);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                e.printStackTrace();
                System.out.println("not to add");
            }
        }
        return student;

    }
}
