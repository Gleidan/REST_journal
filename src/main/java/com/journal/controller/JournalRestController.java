package com.journal.controller;

import com.journal.model.Child;
import com.journal.service.impl.ChildServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JournalRestController {

    @Autowired
    private ChildServiceImpl childService;

    @GetMapping("/childs")
    public List<Child> showAllChilds() {
        return childService.getAllChilds();
    }
}
