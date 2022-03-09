package mangeSystem;

import Entity.Course;
import Entity.Employee;
import Entity.Professor;
import Entity.Student;

import java.util.Scanner;

public class EmployeeSystem {
    Employee employee;
    Student student;
    Professor professor;
    Scanner scanner = new Scanner(System.in);
    public Student singUp(){
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert college");
        String college = scanner.next();
        student = new Student(null,name,12,college,null);
        return student;
    }
    public Employee employeeSingUp(){
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert college");
        String college = scanner.next();
        employee = new Employee(null,name,12,"ACTIVE",null);
        return employee;
    }
    public Professor professorSingUp(){
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert college");
        String college = scanner.next();
        System.out.println("please insert status between ft and ht");
        //add enum and checking for input
        String status = scanner.next();
        professor = new Professor(null,name,12,status,null,null,college);
        return professor;
    }
    public Course insertCourse(){
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert college");
        String college = scanner.next();
        System.out.println("please isnert unit");
        int unoit = scanner.nextInt();
        Course course = new Course(unoit,college,null,name);
        return course;
    }
}
