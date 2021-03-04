package com.journal.service;

import com.journal.model.Child;

import java.util.List;

public interface ChildService {

    public List<Child> getAllChilds();

    public void saveChild(Child child);

    public Child getChild(int id);

    public void deleteChild(int id);
}
