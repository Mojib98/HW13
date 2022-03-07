package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    public Employee(Integer id, String name, Integer passcode, String status,Integer e) {
        super(id, name, passcode);
        this.status = status;
        this.EmployeeId = e;
    }

    private String status;
}
