package service.impl.employee;

import Entity.Course;
import repository.imp.CourseRepositoryEmployee;
import service.Service;

import java.util.List;

public class CourseServiceEmployee implements Service<Course> {
    CourseRepositoryEmployee CRE=new CourseRepositoryEmployee();
    @Override
    public void add(Course course) {
        try {
            CRE.add(course);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("wrong in adding Course");
        }
    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = null;
        try {
            courseList = CRE.findAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not find");
        }
        return courseList;
    }

    @Override
    public Course showInformation(int id) {
        Course course = null;
        try {
            course = showInformation(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User not find");
        }
        return course;
    }
}
