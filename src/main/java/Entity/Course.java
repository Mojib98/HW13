package Entity;

import lombok.*;

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

    @Override
    public String toString() {
        return  super.toString()+"\n\tCourse{" +
                "\tname='" + name + '\'' +
                "\t} "  ;
    }
}
