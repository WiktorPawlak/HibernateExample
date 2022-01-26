package p.lodz.pl.embeddable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity(name = "student") //name for table(relation) we use in code, for example in queries
@Table(name = "STUDENT") //name for table(relation) in database
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Integer studentId;
    private String name;
    private int age;

    @ElementCollection
    private List<Mark> marks = Arrays.asList(new Mark[9 * 9]);

    protected Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addMark(int i, Mark mark) {
        marks.set(i, mark);
    }

    public List<Mark> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getStudentId() {
        return studentId;
    }
}
