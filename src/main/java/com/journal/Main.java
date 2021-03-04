package com.journal;

import com.journal.model.Child;
import com.journal.model.Group;
import com.journal.model.Mark;
import com.journal.model.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Mark.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


//        Group group = new Group("Ingener");
        session.beginTransaction();
        Child child1 = session.get(Child.class, 1);
        Child child2 = session.get(Child.class, 2);

        Mark mark5 = new Mark(5);
        mark5.addChildToMark(child1);
        mark5.addChildToMark(child2);

        Section section1 = new Section("Chess");
        section1.addChildToSection(child1);
        section1.addChildToSection(child2);
//        group.addChildInGroup(child1);
//        group.addChildInGroup(child2);

        session.save(mark5);
        session.save(section1);
        session.update(child1);
        session.update(child2);
//        session.save(group);
//        session.save(child1);
//        session.save(child2);

//        Child child = new Child("Kesha", "Sidorov", 22);
//        Group group = new Group("mathematic");
//        Mark mark = new Mark(4);
//        Section section = new Section("Chess");
//        session.save(child);
//        session.save(group);
//        session.save(mark);
//        session.save(section);

        session.getTransaction().commit();
        factory.close();
    }
}
