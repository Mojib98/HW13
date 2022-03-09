import Entity.Employee;
import Entity.Professor;
import mangeSystem.Manage;
import service.impl.employee.EmployeeServiceEmpolyee;
import service.impl.employee.ProfessorServiceEmployee;

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
        m.manu();

    }
}
