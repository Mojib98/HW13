package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
