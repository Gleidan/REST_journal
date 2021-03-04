package com.journal.dao.impl;

import com.journal.dao.ChildDao;
import com.journal.model.Child;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChildDaoImpl implements ChildDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Child> getAllChilds() {
        Session session = sessionFactory.getCurrentSession();

        Query<Child> query = session.createQuery("from Child", Child.class);
        List<Child> allChild = query.getResultList();
        
        return allChild;
    }

    @Override
    public void saveChild(Child child) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(child);
    }

    @Override
    public Child getChild(int id) {
        Session session = sessionFactory.getCurrentSession();

        Child child = session.get(Child.class, id);

        return child;
    }

    @Override
    public void deleteChild(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Child> query = session.createQuery("delete from Child " + "where id =:childId");
        query.setParameter("childId", id);
        query.executeUpdate();
    }
}
