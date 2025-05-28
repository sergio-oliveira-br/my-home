package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.service.PastCleaningService;
import com.github.sergiooliveirabr.myhome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    private final PastCleaningService pastCleaningService;
    private final RoomService roomService;

    @Autowired
    public IndexController(PastCleaningService pastCleaningService, RoomService roomService) {
        this.pastCleaningService = pastCleaningService;
        this.roomService = roomService;
    }

    @GetMapping
    public String index(Model model) {

        String date = String.valueOf(pastCleaningService.findLastCleaning().get().getDataHeld());
        String person = pastCleaningService.findLastCleaning().get().getResponsiblePerson().getName();

        //First card (Next Schedule)
        model.addAttribute("next_room",
                "The next cleaning is up to " + roomService.getNextRoomInRotation().getName());

        //Second card (Past Cleaning)
        model.addAttribute("display_days_ago",
                pastCleaningService.getFormattedLastCleaningDetails());

        model.addAttribute("last_cleaning",
                person + " carried out the most recent cleaning on " + date);

        return "index";
    }
}
