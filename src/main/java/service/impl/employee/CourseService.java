package service.impl.employee;

import Entity.Course;
import Entity.Professor;
import repository.imp.CourseRepository;

import java.util.List;

public class CourseService {
    CourseRepository courseRepository = new CourseRepository();



    public List<Course> allCourse(){
        try {
            return courseRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Course findCourse(int id){
        return courseRepository.findCourse(id);
    }

}
