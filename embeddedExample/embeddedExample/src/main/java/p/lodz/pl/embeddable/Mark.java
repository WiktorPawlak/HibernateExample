package p.lodz.pl.embeddable;

import javax.persistence.*;

@Embeddable
public class Mark {
    private int value;
    private boolean editable = false;


    protected Mark() {
    }

    public Mark(int value, boolean editable) {
        this.value = value;
        this.editable = editable;
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
