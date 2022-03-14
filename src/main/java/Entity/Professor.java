package Entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Professor extends Employee {
    private Integer allUnit;
    private String college;

    public Professor(Integer id, String name, Integer passcode, String status, Integer code, Integer allUnit, String college) {
        super(id, name, passcode, status, code);
        this.allUnit = allUnit;
        this.college = college;
    }
}
