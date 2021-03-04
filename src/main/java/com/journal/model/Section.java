package com.journal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String selection;

    @ManyToMany
    @JoinTable(
            name = "child_section"
            ,joinColumns = @JoinColumn(name = "section_id")
            ,inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Child> childs;

    public void addChildToSection(Child child){
        if(childs == null){
            childs = new ArrayList<>();
        }
        childs.add(child);
    }


    public Section() {
    }

    public Section(String selection) {
        this.selection = selection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
}
