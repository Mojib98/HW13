package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends Person{
    private Integer EmployeeId;
    public Employee(Integer id, String name, Integer passcode, String status,Integer EmployeeId) {
        super(id, name, passcode);
        this.status = status;
        this.EmployeeId = EmployeeId;
    }

    @Override
    public String toString() {
        return  super.toString()+"\n\tEmployee{" +
                "\tEmployeeId=" + EmployeeId +
                "\t, status='" + status + '\'' +
                "\t} ";
    }

    private String status;
}
