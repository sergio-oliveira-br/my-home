package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.cleaning.Room;
import com.github.sergiooliveirabr.myhome.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String viewSchedulePage(Model model) {
        model.addAttribute("schedules", scheduleService.getCurrentSchedule());
        //This will display the options of the rooms avaible to start the schedule
        model.addAttribute("roomoptions", Room.values());
        return "schedule";
    }
}
