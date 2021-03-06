package Entity;

import lombok.*;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseCourse extends BaseClass {
    private Integer unit;
    private String college;

    public BaseCourse(Integer id, String name, Integer unit, String college, Professor professor) {
        super(id, name);
        this.unit = unit;
        this.college = college;
        this.professor = professor;
    }

    @ManyToOne
    private Professor professor;

    @Override
    public String toString() {
        return super.toString() +
                "\tunit=" + unit +
                "\t, college='" + college + '\'' +
                "\t, professor=" + professor;
    }
}
