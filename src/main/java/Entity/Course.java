package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course extends BaseCourse{
    private String name;

    public Course(Integer unit, String college, Professor professor,String name) {
        super(unit, college, professor);
        this.name = name;
    }
  /*  @ManyToMany
    private Set<Student> students;*/
}
