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
   StudentRepository studentRepository = new StudentRepository();

    public void add(Course course) {
        try {

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
    private Student student(){
        return null;
    }

}
