package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends Person {
    private String college;
    private Integer allUnit;
    private Integer idStudent;

    public Student(Integer id, String name, Integer passcode,String college, Integer allUnit) {
        super(id, name, passcode);
        this.college = college;
        this.allUnit = allUnit;
    }
   /*     @ManyToMany(mappedBy = "students")
        @JoinTable(
                name = "course_student",
                joinColumns = { @JoinColumn(name = "student_id") },
                inverseJoinColumns = { @JoinColumn(name = "course_id") }
        )
        private Set<SectionCourse> courseSet;*/


}
