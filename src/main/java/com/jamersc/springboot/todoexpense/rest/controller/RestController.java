package com.jamersc.springboot.todoexpense.rest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todoexpense")
public class RestController {

    @GetMapping("/showLoginSignup")
    public String showLoginSignup() {
        return "login-signup";
    }
    @GetMapping("/showIndex")
    public String showIndex() {
    // public String showIndex(Model theModel) {

        // theModel.addAttribute("theDate", new java.util.Date());

        return "index";
    }

    @GetMapping("/showTodo")
    public String showTodo() {
        return "todo";
    }

    @GetMapping("/showExpenses")
    public String showExpenses() {
        return "expenses";
    }
}
