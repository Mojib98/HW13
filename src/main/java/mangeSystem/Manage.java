package mangeSystem;

import Entity.*;
import service.impl.*;

import java.util.List;
import java.util.Scanner;

public class Manage {
    private Integer id, password;
    Scanner scanner;
    EmployeeSystem employeeSystem;
    StudentServiceEmployee studentServiceEmployee;
    EmployeeServiceEmpolyee employeeServiceEmpolyee;
    ProfessorServiceEmployee professorServiceEmployee;
    CourseServiceEmployee courseServiceEmployee;
    StudentService studentService;
    CourseService courseService;
    ProfessorService professorService;
    Student student;
    LoginService loginService;


    public Manage() {
        professorService = new ProfessorService();
        professorServiceEmployee = new ProfessorServiceEmployee();
        employeeServiceEmpolyee = new EmployeeServiceEmpolyee();
        studentServiceEmployee = new StudentServiceEmployee();
        courseServiceEmployee = new CourseServiceEmployee();

        employeeSystem = new EmployeeSystem();
        courseService = new CourseService();
        loginService = new LoginService();
        scanner = new Scanner(System.in);


    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void manu() {
        System.out.println("please insert your ID");
        id = scanner.nextInt();
        System.out.println("please insert your passcode");
        password = scanner.nextInt();
        if (loginService.checking(id, password)) {
            if (id >= 4000) {
                studentMenu();
            } else if (id <= 3000 & id > 2000) {
                professorMenu();
            } else if (id >= 1000 & id < 2000) {
                employee();
            }
        }
    }

    private void employee() {
        boolean isrun = true;
        while (isrun) {
            System.out.println("\tfor menu employee insert 1\n" +
                    "\tfor menu student insert 2\n" +
                    "\tfor mene professor insert 3\n" +
                    "\tfor menu course insert 4\n" +
                    "\tfor show your info insert 5\n" +
                    "\tfoe exit insert 6 ");
            int selection = scanner.nextInt();
            switch (selection) {
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
                    break;
                case 5:
                    Employee employee = employeeServiceEmpolyee.showInformation(id);
                    System.out.println(employee);
                    break;
                case 6:
                    isrun = false;
            }

        }
    }

    private void studentEmployee() {
        boolean isRun = true;
        System.out.println("\tfor sing up student insert 1\n" +
                "\tfor see All student insert 2\n" +
                "\tfor find Student insert 3\n");
        int section = scanner.nextInt();
        switch (section) {
            case 1:
                student = employeeSystem.singUp();
                studentServiceEmployee.add(student);
                break;
            case 2:
                List<Student> list = studentServiceEmployee.findAll();
                list.stream().forEach(System.out::println);
                break;
            case 3:
                System.out.println("\tplease insert id ");
                int studentId = scanner.nextInt();
                Student student = studentServiceEmployee.showInformation(studentId);
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("not find");
                }
        }
    }

    private void employeeMenuEmployee() {
        System.out.println("\tfor insert employee select 1\n" +
                "\tfor see All employee select 2\n" +
                "\tfor find select 3");
        int section = scanner.nextInt();
        switch (section) {
            case 1:
                try {
                    Employee employee = employeeSystem.employeeSingUp();
                    employeeServiceEmpolyee.add(employee);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                List<Employee> list = employeeServiceEmpolyee.findAll();
                list.stream().forEach(System.out::println);
                break;
            case 3:
                System.out.println("please inset id");
                int idE = scanner.nextInt();
                Employee employee = employeeServiceEmpolyee.showInformation(id);
                if (employee != null) {
                    System.out.println(employee);
                } else {
                    System.out.println("not find");
                }
        }

    }

    private void professorMenuEmployee() {
        System.out.println("\tfor insert professor select 1\n" +
                "\tfor see all professor insert 2\n" +
                "\tfor find professor insert 3");
        int section = scanner.nextInt();
        switch (section) {
            case 1:
                Professor p = employeeSystem.professorSingUp();
                professorServiceEmployee.add(p);
                break;
            case 2:
                allProfessor();
                break;
            case 3:
                Professor professor = findProfessor();
                if (professor != null) {
                    System.out.println(professor);
                } else {
                    System.out.println("not find");
                }
        }

    }

    private void courseEmployee() {
        System.out.println("\tfor insert course select 1\n" +
                "\tfor see All course insert 2\n" +
                "\tfor find course insert 3");
        int section = scanner.nextInt();
        switch (section) {
            case 1:
                allProfessor();
                Professor professor = findProfessor();
                Course course = employeeSystem.insertCourse();
                course.setProfessor(professor);
                courseServiceEmployee.add(course);
                break;
            case 2:
                List<Course> list =courseServiceEmployee.findAll();
                list.stream().forEach(System.out::println);
                break;
            case 3:
                System.out.println("please inset id");
                int idE = scanner.nextInt();
                Course course1 = courseServiceEmployee.showInformation(idE);
                if (course1 != null) {
                    System.out.println(course1);
                } else {
                    System.out.println("not find");
                }


        }
    }

    private void studentMenu() {
        studentService = new StudentService(this.id);
        boolean isRun = true;
        while (isRun) {
            System.out.println("\tFor see your information insert 1 \n" +
                    "\tfor see your all course insert 2\n" +
                    "\tfor section course insert 3\n" +
                    "\tfor remove insert 4\n" +
                    "\tfor exit insert 5");
            int sectiom = scanner.nextInt();
            switch (sectiom) {
                case 1:
                  Student student1=  studentService.showInfo();
                    System.out.println(student1);
                    break;
                case 2:
                    List<SectionCourse> list1 = studentService.findAll();
                    list1.stream().forEach(System.out::println);
                    break;
                case 3:
                   var list= courseService.allCourse();
                   list.forEach(System.out::println);
                    System.out.println("please select by id");
                    int s = scanner.nextInt();
                    Course course1 = courseService.findCourse(s);
                    try {

                        studentService.add(course1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    List<SectionCourse> list4 = studentService.findAll();
                    list4.stream().forEach(System.out::println);
                    System.out.println("please select");
                    int sect = scanner.nextInt();
                    studentService.remove(sect);
                    break;
                case 5:
                    isRun =false;
            }
        }
    }

    private void professorMenu() {
        boolean isRun = true;
        professorService.setId(this.id);
        while (isRun){
        System.out.println("\tfor insert score select 1\n" +
                "\tfor see your salary  and information select 2");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1:
                List<SectionCourse> list=professorService.myStudent();
                list.stream().forEach(System.out::println);
                System.out.println("\tplease insert id");
                int idS=scanner.nextInt();
                System.out.println("please insert score");
                int score = scanner.nextInt();
                professorService.insertScore(idS,score);
                break;
            case 2:
                Professor professor = professorService.myInfo();
                if (professor.getStatus().equals("ft")){
                    System.out.println("salary = "+professor.getAllUnit()*10000);
                    System.out.println(professor);
                }else {
                    System.out.println("salary = "+10000);
                    System.out.println(professor);
                }
            case 3:

        }

    }}

    private Professor findProfessor() {
        System.out.println("please insert professor Id");
        int pID = scanner.nextInt();
        Professor professor = professorServiceEmployee.showInformation(pID);
        return professor;

    }

    private void allProfessor() {
        List<Employee> list = professorServiceEmployee.findAll();
        list.stream().forEach(System.out::println);
    }
}
