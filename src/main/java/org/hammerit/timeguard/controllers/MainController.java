package org.hammerit.timeguard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    @GetMapping("/")
    public String showMainMenu() {
        return "homepage";
    }


}
