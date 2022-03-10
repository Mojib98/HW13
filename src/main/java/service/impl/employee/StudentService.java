package service.impl.employee;

import Entity.Course;
import Entity.SectionCourse;
import Entity.Student;
import repository.imp.StudentRepository;
import service.Service;

import java.util.List;

public class StudentService {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    private Student student;
   StudentRepository studentRepository = new StudentRepository();

    public void add(Course course) {
        try {
         student();
        SectionCourse course1 = new SectionCourse();
        course1.setName(course.getName());
        course1.setId(course.getId());
        course1.setCollege(course.getCollege());
        course1.setProfessor(course.getProfessor());
        course1.setUnit(course.getUnit());
        course1.setStudent(student);
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
        student=studentRepository.findMyStudent(id);
    }
    public void showInfo(){
        student();
        System.out.println(student);
    }
    public List<SectionCourse> findAll(){
       return studentRepository.findAll();

    }

}
