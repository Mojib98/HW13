package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class SectionCourse extends BaseCourse{
  /*  public SectionCourse(Integer unit, String college, Entity.Professor professor, Integer tudentId, Entity.Student student) {
        super(unit, college, professor);
        this.tudentId = tudentId;
        this.student = student;
    }*/
    private Integer score;
    public SectionCourse(Integer unit, String college, Professor professor, Student student) {
        super(unit, college, professor);
        this.student = student;
    }

    @ManyToOne
    private Student student;
     @ManyToOne(fetch = FetchType.EAGER)
   private Course course;


}
