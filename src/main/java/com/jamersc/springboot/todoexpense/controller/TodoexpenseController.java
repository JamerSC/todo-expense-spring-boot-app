package com.jamersc.springboot.todoexpense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoexpenseController {


    // Show form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Process form
    @RequestMapping("/processLogin")
    public String processLogin() {
        return "index";
    }

    /*

    @GetMapping("/login")
    public String showLogin(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "login";
    }

    */
}
