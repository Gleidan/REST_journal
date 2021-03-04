package com.journal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "childs")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "child_mark"
            , joinColumns = @JoinColumn( name = "child_id")
            , inverseJoinColumns = @JoinColumn (name = "mark_id")
    )
    private List<Mark> marks;

    public void addMarkToChild(Mark mark){
        if(marks == null){
            marks = new ArrayList<>();
        }
        marks.add(mark);
    }

    @ManyToMany
    @JoinTable(
            name = "child_section"
            ,joinColumns = @JoinColumn(name = "child_id")
            ,inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sections;

    private void addSectionToChild(Section section){
        if(sections == null){
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public Child() {
    }

    public Child(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
