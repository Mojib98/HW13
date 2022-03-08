package service.impl.employee;

import Entity.Professor;
import Entity.Student;
import repository.imp.StudentRepositoryEmployee;
import service.Service;

import java.util.List;
import java.util.Random;

public class StudentServiceEmployee implements Service<Student> {
    StudentRepositoryEmployee sRC=new StudentRepositoryEmployee();
    @Override
    public void add(Student student) {
        Random random = new Random();
        int id = random.ints(4, 4000, 6000).findFirst().getAsInt();
        student.setIdStudent(id);
        try {
            sRC.add(student);
        }catch (Exception e){
            System.out.println("not to add");
        }

    }

    @Override
    public void remove(Student student) {

    }

    @Override
    public List<Student> findAll() {
        List<Student> list = null;
        try {
            list= sRC.findAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not find");
        }
        return list;
    }

    @Override
    public Student showInformation(int id) {
        Student student = null;
        try {
            student =sRC.showInformation(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User not find");
        }
        return student;

    }
}
