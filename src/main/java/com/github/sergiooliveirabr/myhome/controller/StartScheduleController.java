package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start-schedule")
public class StartScheduleController {

    @GetMapping
    public String viewStartSchedule(Model model) {

        //This will display the options of the rooms avaible to start the schedule
        model.addAttribute("roomoptions", Room.values());

        return "config/start-schedule";
    }

}
