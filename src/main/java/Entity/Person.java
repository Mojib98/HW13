package Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person extends BaseClass {
    public Person(Integer id, String name, Integer passcode) {
        super(id, name);
        this.passcode = passcode;
    }

    private Integer passcode;
}
