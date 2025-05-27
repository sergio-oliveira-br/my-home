package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.Cleaning;
import com.github.sergiooliveirabr.myhome.service.PastCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/past-cleanings")
public class PastCleaningsController {

    private final PastCleaningService pastCleaningService;

    @Autowired
    public PastCleaningsController(PastCleaningService pastCleaningService) {
        this.pastCleaningService = pastCleaningService;
    }

    @GetMapping
    public String viewPastCleanings(Model model) {
        model.addAttribute("history", pastCleaningService.findAll());
        return "past-cleanings";
    }
}
