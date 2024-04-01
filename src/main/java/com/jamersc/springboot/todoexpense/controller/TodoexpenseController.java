package com.jamersc.springboot.todoexpense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoexpenseController {

    @GetMapping("/login")
    public String showLogin(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "login-signup";
    }
}
