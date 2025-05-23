package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.service.NewCleaningService;
import com.github.sergiooliveirabr.myhome.service.PersonService;
import com.github.sergiooliveirabr.myhome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-cleaning")
public class NewCleaningController {

    private final NewCleaningService newCleaningService;
    private final PersonService personService;
    private final RoomService roomService;

    @Autowired
    public NewCleaningController(NewCleaningService newCleaningService,
                                 PersonService personService,
                                 RoomService roomService) {
        this.newCleaningService = newCleaningService;
        this.personService = personService;
        this.roomService = roomService;
    }

    @GetMapping
    public String viewNewCleaningPage(Model model) {
        model.addAttribute("cleaning", new Cleaning());
        model.addAttribute("tenant", personService.findAll());
        model.addAttribute("rooms_options", roomService.findAll());
        return "new-cleaning";
    }

    @PostMapping("/add")
    public String addNewClean(@ModelAttribute Cleaning cleaning) {
        newCleaningService.save(cleaning);
        return "redirect:/new-cleaning";
    }
}
