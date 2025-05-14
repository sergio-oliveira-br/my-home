package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.Person;
import com.github.sergiooliveirabr.myhome.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String viewPersonPage(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("tenant", personService.findAll());
        return "person";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/person";
    }
}
