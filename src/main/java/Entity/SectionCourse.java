package Entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class SectionCourse extends BaseCourse{
    @ManyToMany
    private List<Student> studentList;


}
