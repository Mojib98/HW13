package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    private String college;
    private Integer allUnit;

    public Student(Integer id, String name, Integer passcode, String college, Integer allUnit) {
        super(id, name, passcode);
        this.college = college;
        this.allUnit = allUnit;
    }
}
