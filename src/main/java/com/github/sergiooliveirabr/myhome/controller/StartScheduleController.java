package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import com.github.sergiooliveirabr.myhome.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/start-schedule")
public class StartScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public StartScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String viewStartSchedulePage(Model model) {

        //This will display the options of the rooms avaible to start the schedule
        model.addAttribute("roomoptions", Room.values());

        model.addAttribute("schedules", scheduleService.getCurrentSchedule());

        return "config/start-schedule";
    }

    @PostMapping("/generate")
    public String startSchedule(@RequestParam Room room) {
        scheduleService.initializeSchedule(room);

        return "redirect:/start-schedule";
    }

}
