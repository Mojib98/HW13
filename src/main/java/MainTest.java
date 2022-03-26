import Entity.BaseClass;
import Entity.Employee;
import Entity.Professor;
import mangeSystem.Manage;
import repository.imp.EmployeeRepositoryEmployee;
import service.impl.EmployeeServiceEmpolyee;
import service.impl.ProfessorService;

public class MainTest {
    public static void main(String[] args) {
     //   BaseClass b =new Employee();
        Manage m = new Manage();
        while (true) {
            try {
                m.manu();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\t\t!!!SOME THING WRONG DO AGAIN!!! ");
                continue;
            }
        }
    }

}
