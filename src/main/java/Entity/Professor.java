package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor extends Employee {
    private Integer allUnit;
    private String college;

    public Professor(Integer id, String name, Integer passcode, String status, Integer e, Integer allUnit, String college) {
        super(id, name, passcode, status, e);
        this.allUnit = allUnit;
        this.college = college;
    }
}
