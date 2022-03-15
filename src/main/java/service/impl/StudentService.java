package service.impl;

import Entity.Course;
import Entity.SectionCourse;
import Entity.Student;
import org.hibernate.SessionFactory;
import repository.imp.SessionFactorySingleton;
import repository.imp.StudentRepository;
import service.Service;

import java.util.List;

public class StudentService {
    private Integer id;


    private Student student = null;
    private StudentRepository studentRepository;
    SessionFactory sessionFactory;

    public StudentService() {
    }

    public StudentService(Integer id) {
        this.id=id;
        studentRepository = new StudentRepository(id);
        sessionFactory = SessionFactorySingleton.getInstance();
    }

    public void add(Course course) {
        if (checkCourse(course) & checkUnit(course.getUnit())) {
            System.out.println("cant select this course");
            return;
        }
        SectionCourse course1 = new SectionCourse();
        student();
        course1.setName(course.getName());
        course1.setId(course.getId());
        course1.setCollege(course.getCollege());
        //    System.out.println(course.getProfessor());
        course1.setProfessor(course.getProfessor());//
        course1.setUnit(course.getUnit());
        course1.setStudent(student);//
        course1.setCourse(course);
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                studentRepository.add(course1);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                System.out.println("dont added");
            }
        }


    }

    public void remove(int id) {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                SectionCourse c = studentRepository.showInformation(id);
                studentRepository.remove(c);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                System.out.println("dont remove");
            }
        }
    }

    private void student() {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                this.student = studentRepository.findMyStudent(this.id);
                t.commit();
            } catch (Exception e) {
                t.rollback();
                System.out.println("dont remove");
            }

        }
    }

    public Student showInfo() {
        student();
        return this.student;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SectionCourse> findAll() {
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                return studentRepository.findAll();
            } catch (Exception e) {
                t.rollback();
                System.out.println("dont remove");
                return null;
            }

        }

    }
    private boolean checkUnit(Integer check){
        Long unit = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
                unit = studentRepository.checkerUnit();
                t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
                System.out.println("cant check unit");
                return true;
            }

        }
        System.out.println("check unit "+unit);
        if(unit == null){
            return true;
        }
        if (unit+check>18){
            return false;
        }else {
            return true;
        }
    }
    private boolean checkCourse(Course course){
        Integer check = null;
        try (var session = sessionFactory.getCurrentSession()) {
            var t = session.getTransaction();
            try {
                t.begin();
               check= studentRepository.checkCourse(course);
            } catch (Exception e) {
                e.printStackTrace();
                t.rollback();
                System.out.println("cant check course");
                return false;
            }
            System.out.println(check+" " +
                    "course");
        if (check !=null){
            return true;
        }
        else return false;
    }

}
}
