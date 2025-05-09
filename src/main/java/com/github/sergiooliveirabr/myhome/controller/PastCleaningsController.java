package com.github.sergiooliveirabr.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/past-cleanings")
public class PastCleaningsController {

    @GetMapping
    public String viewPastCleanings() {
        return "past-cleanings";
    }
}
