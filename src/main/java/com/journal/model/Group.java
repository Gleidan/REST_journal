package com.journal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name_group;

    @OneToMany(mappedBy = "group")
    private List<Child> childList;

    public Group() {
    }

    public Group(String name_group) {
        this.name_group = name_group;
    }

    public void addChildInGroup(Child child){
        if(childList == null){
            childList = new ArrayList<>();
        }
        childList.add(child);
        child.setGroup(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }
}
