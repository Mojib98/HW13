package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course extends BaseCourse{
    private String ss;

    public Course(Integer unit, String college, Professor professor, String ss) {
        super(unit, college, professor);
        this.ss = ss;
    }
}
