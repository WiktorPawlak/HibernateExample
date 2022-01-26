package p.lodz.pl.model;

import javax.persistence.*;

@Entity(name = "mark")
@Table(name = "MARK")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fieldId")
    private Integer fieldId;
    private int value;
    private boolean editable = false;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "studentId", nullable = false)
//    private Student student;

    protected Mark() {
    }

    public Mark(int value, boolean editable) {
        this.value = value;
        this.editable = editable;
//        this.student = student;
    }

//    public Student getStudent() {
//        return student;
//    }

    public Integer getFieldId() {
        return fieldId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
