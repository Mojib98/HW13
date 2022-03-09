package mangeSystem;

import Entity.Course;
import Entity.Employee;
import Entity.Professor;
import Entity.Student;
import service.impl.employee.CourseServiceEmployee;
import service.impl.employee.EmployeeServiceEmpolyee;
import service.impl.employee.ProfessorServiceEmployee;
import service.impl.employee.StudentServiceEmployee;

import java.util.Scanner;

public class Manage {
    private Integer id,password;
    Scanner scanner = new Scanner(System.in);
    EmployeeSystem employeeSystem = new EmployeeSystem();
    StudentServiceEmployee studentServiceEmployee = new StudentServiceEmployee();
    EmployeeServiceEmpolyee employeeServiceEmpolyee = new EmployeeServiceEmpolyee();
    ProfessorServiceEmployee professorServiceEmployee = new ProfessorServiceEmployee();
    CourseServiceEmployee courseServiceEmployee = new CourseServiceEmployee();
    Student student;
    public void manu(){
     /*   System.out.println("please insert your ID");
        id = scanner.nextInt();
        System.out.println("please insert your passcode");
        password = scanner.nextInt();*/
        employee();
    }

    private void employee(){
        boolean isrun = true;
        while (isrun){
        System.out.println("for menu employee insert 1\n" +
                "for menu student insert 2\n" +
                "for mene professor insert 3\n" +
                "for menu course insert 4 ");
        int selection = scanner.nextInt();
        switch (selection){
            case 1:
                employeeMenuEmployee();
                break;
            case 2:
                studentEmployee();
                break;
            case 3:
                professorMenuEmployee();
                break;
            case 4:
                courseEmployee();
            case 5:
                isrun = false;
        }

    }}
    private void studentEmployee(){
        boolean isRun = true;
        System.out.println("for sing up student insert 1\n" +
                "for deactivate student insert 2");
        int section = scanner.nextInt();
        switch (section){
            case 1:
                student = employeeSystem.singUp();
                studentServiceEmployee.add(student);
                break;
            case 2:
            case 3:
                isRun = false;
        }
    }
    private void employeeMenuEmployee(){
        boolean isRun = true;
        Employee employee = employeeSystem.employeeSingUp();
        employeeServiceEmpolyee.add(employee);
    }
    private void professorMenuEmployee(){
        Professor p = employeeSystem.professorSingUp();
        professorServiceEmployee.add(p);
    }
    private void courseEmployee(){
        System.out.println("please insert professor Id");
        int pID = scanner.nextInt();
        Professor professor = professorServiceEmployee.showInformation(pID);
        Course course = employeeSystem.insertCourse();
        course.setProfessor(professor);
        courseServiceEmployee.add(course);
    }
    private void studentMenu(){
        boolean idRun=true;
        System.out.println("For see your information insert 1 \n" +
                "for see your all course insert 2" +
                "for section course insert 3");
    }

}
