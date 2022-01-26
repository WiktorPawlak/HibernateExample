package p.lodz.pl.model;

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

    //unidirectional association {"one to many" <=> "Student has many grade"}
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    //@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mark> marks = Arrays.asList(new Mark[9 * 9]);
    //every commented out line of code in Mark class, Student class and in StudentTest
    //is an alternative to these two uncommented annotations above. The commented out code
    //defines bidirectional "one to many" association between two relations.
    //"mappedBy" attribute marks a class as the inverse side of the relation, which means
    //that the other side of the relation is the owning side.
    //It is a good practice to mark the "ManyToOne" side as the owning side.
    //https://www.baeldung.com/hibernate-one-to-many

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
