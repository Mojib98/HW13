package service.impl.employee;

import Entity.Course;
import repository.imp.CourseRepository;

import java.util.List;

public class CourseService {
    CourseRepository courseRepository = new CourseRepository();



    public List<Course> allCourse(){
        return courseRepository.findAll();

    }
    public Course findCourse(int id){
        return courseRepository.findCourse(id);
    }
}
