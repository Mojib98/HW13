package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SectionCourse extends BaseCourse{
  /*  public SectionCourse(Integer unit, String college, Entity.Professor professor, Integer tudentId, Entity.Student student) {
        super(unit, college, professor);
        this.tudentId = tudentId;
        this.student = student;
    }*/

    public SectionCourse(Integer unit, String college, Professor professor, Student student) {
        super(unit, college, professor);
        this.student = student;
    }

    @ManyToOne
    private Student student;
     @ManyToOne
   private Course course;


}
