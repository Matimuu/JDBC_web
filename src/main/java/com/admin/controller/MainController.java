package com.admin.controller;

import com.admin.dao.DAO;
import com.admin.model.Person;
import com.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 17:09
 */
@Controller
public class MainController {
    @Autowired
    private DAO dao;
    @RequestMapping(value = "/")
    public ModelAndView listPerson(ModelAndView model) {
        List<User> personList = dao.list();

        model.addObject("personList", personList);
        model.setViewName("index");

        return model;
    }
}
