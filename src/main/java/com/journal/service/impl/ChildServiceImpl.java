package com.journal.service.impl;

import com.journal.dao.ChildDao;
import com.journal.model.Child;
import com.journal.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildDao childDao;

    @Override
    @Transactional
    public List<Child> getAllChilds() {
        return childDao.getAllChilds();
    }

    @Override
    @Transactional
    public void saveChild(Child child) {
        childDao.saveChild(child);
    }

    @Override
    @Transactional
    public Child getChild(int id) {
        return childDao.getChild(id);
    }

    @Override
    @Transactional
    public void deleteChild(int id) {
        childDao.deleteChild(id);
    }
}
