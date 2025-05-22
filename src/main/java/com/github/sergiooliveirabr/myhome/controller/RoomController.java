package com.github.sergiooliveirabr.myhome.controller;

import com.github.sergiooliveirabr.myhome.entity.Room;
import com.github.sergiooliveirabr.myhome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String viewRoomPage(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("allrooms", roomService.findAll());
        return "config/room";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute Room room) {
        roomService.save(room);
        return "redirect:/room";
    }
}