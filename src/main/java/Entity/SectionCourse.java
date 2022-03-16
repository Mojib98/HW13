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

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;
     @ManyToOne(fetch = FetchType.EAGER)
   private Course course;

    @Override
    public String toString() {
        return super.toString()+"\tSectionCourse{" +
                "\tscore=" + score +
                "\t, student=" + student +
                "\t, course=" + course +
                "\t} " ;
    }
}
