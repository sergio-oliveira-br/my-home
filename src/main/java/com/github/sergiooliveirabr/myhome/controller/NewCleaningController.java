package com.github.sergiooliveirabr.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-cleaning")
public class NewCleaningController {

    @GetMapping
    public String viewNewCleaning() {
        return "new-cleaning";
    }
}
