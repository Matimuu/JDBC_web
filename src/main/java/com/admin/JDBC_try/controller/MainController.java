package com.admin.JDBC_try.controller;

import com.admin.JDBC_try.dao.DAO;
import com.admin.JDBC_try.model.Person;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Person> personList = dao.list();

        model.addObject("personList", personList);
        model.setViewName("index");

        return model;
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newPerson(ModelAndView model) {
        Person newPerson = new Person();

        model.addObject("person", newPerson);
        model.setViewName("person_form");

        return model;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Person person) {
        if (person.getId() == null) {
            dao.save(person);
        } else {
            dao.update(person);
        }

        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPerson(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Person person = dao.get(id);

        ModelAndView model = new ModelAndView("person_form");

        model.addObject("person", person);

        return model;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deletePerson(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);

        return new ModelAndView("redirect:/");
    }
}
