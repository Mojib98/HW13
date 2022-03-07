import Entity.Employee;
import service.impl.employee.EmployeeServiceEmpolyee;

public class MainTest {
    public static void main(String[] args) {
        Employee e = new Employee(null,"majid",12,"ACTIVE",null);
        EmployeeServiceEmpolyee es = new EmployeeServiceEmpolyee();
        es.add(e);
        System.out.println(es.findAll());

    }
}
