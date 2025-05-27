package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.service.PastCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    private final PastCleaningService pastCleaningService;

    @Autowired
    public IndexController(PastCleaningService pastCleaningService) {
        this.pastCleaningService = pastCleaningService;
    }

    @GetMapping
    public String index(Model model) {

        String date = String.valueOf(pastCleaningService.findLastCleaning().get().getDataHeld());
        String person = pastCleaningService.findLastCleaning().get().getResponsiblePerson().getName();

        model.addAttribute("display_days_ago", pastCleaningService.getFormattedLastCleaningDetails());

        model.addAttribute("last_cleaning",
                person + " carried out the most recent cleaning on " + date);

        return "index";
    }
}
