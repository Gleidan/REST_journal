package com.journal.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int mark;

    @ManyToMany
    @JoinTable(
            name = "child_mark"
            , joinColumns = @JoinColumn( name = "mark_id")
            , inverseJoinColumns = @JoinColumn (name = "child_id")
    )
    private List<Child> childs;

    public void addChildToMark(Child child){
        if(childs == null){
            childs = new ArrayList<>();
        }
        childs.add(child);
    }

    public Mark() {
    }

    public Mark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
