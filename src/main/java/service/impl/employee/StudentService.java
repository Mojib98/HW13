package service.impl.employee;

import Entity.Course;
import Entity.SectionCourse;
import Entity.Student;
import repository.imp.StudentRepository;
import service.Service;

import java.util.List;

public class StudentService {
    private Integer id;


    private Student student;
   StudentRepository studentRepository = new StudentRepository(id);

    public void add(Course course) {
        if (!studentRepository.checkCourse(course)){
            System.out.println("cant select this course");
            return;
        }
        try {
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
        studentRepository.add(course1);

    }catch (Exception e){
            System.out.println("dont added");
        }

    }
    public void remove(int id){
      SectionCourse c=  studentRepository.showInformation(id);
      studentRepository.remove(c);
    }
    private void student(){
        this.student = studentRepository.findMyStudent(this.id);
    }
    public void showInfo(){
        student();
        System.out.println(student);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SectionCourse> findAll(){
       return studentRepository.findAll();

    }

}
