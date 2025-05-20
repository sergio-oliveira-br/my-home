package com.github.sergiooliveirabr.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/config")
public class ConfigController {

    @GetMapping
    public String viewConfigPage(Model model) {
        return "config/config";
    }
}
