package Entity;
import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Person extends BaseClass {
    public Person(Integer id, String name, Integer passcode) {
        super(id, name);
        this.passcode = passcode;
    }

    private Integer passcode;
}
