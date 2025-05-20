package com.github.sergiooliveirabr.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start-schedule")
public class StartScheduleController {

    @GetMapping
    public String viewStartSchedule() {
        return "config/start-schedule";
    }
}
