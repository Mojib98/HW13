import Entity.Employee;
import Entity.Professor;
import Entity.SectionCourse;
import Entity.Student;
import mangeSystem.Manage;
import repository.imp.ProfessRepository;
import repository.imp.StudentRepository;
import service.impl.employee.EmployeeServiceEmpolyee;
import service.impl.employee.ProfessorService;
import service.impl.employee.ProfessorServiceEmployee;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
     /*   Employee e = new Employee(null,"majid",12,"ACTIVE",null);
        EmployeeServiceEmpolyee es = new EmployeeServiceEmpolyee();
        es.add(e);
        System.out.println(es.findAll());
        Professor p =new Professor(null,"majidi",12,"Active",null,null,"math");
        ProfessorServiceEmployee pr = new ProfessorServiceEmployee();
        pr.add(p);*/
        Manage m = new Manage();
       // m.setId(5042);
        //m.manu();
     //   ProfessRepository professRepository = new ProfessRepository(2517);
       //
        // professRepository.myStudent().forEach(System.out::println);
        ProfessorService professorService = new ProfessorService();
      //  professorService.setId(2517);
      //List<SectionCourse> k =  professorService.myStudent();
      professorService.insertScore(1,16);
     //   System.out.println(k);
              //  StudentRepository studentRepository=new StudentRepository();
       // SectionCourse sectionCourse = new SectionCourse();

    }
}
