package com.jamersc.springboot.todoexpense.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoexpenseController {

    @GetMapping("/showLogin")
    public String showLogin() {
        return "login";
    }

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


    // Http Servlet Process
    @RequestMapping("/processLoginSecond")
    public String processLoginSecond(HttpServletRequest request, Model model) {

        // Create an object & get the parameter
        String theUsername = request.getParameter("username");

        // Convert the object into upper case
        theUsername = theUsername.toUpperCase();

        // create a message
        String result = "Hey " + theUsername;

        // add message to the model
        model.addAttribute("message", result);

        return "index";
    }

    // Request Param Annotation
    @PostMapping("/processLoginThird")
    public String processLoginThird(
            @RequestParam("username") String theUsername, Model model) {

        // Convert the object into upper case
        theUsername = theUsername.toUpperCase();

        // create a message
        String result = "Hey " + theUsername;

        // add message to the model
        model.addAttribute("message", result);

        return "index";
    }

    @RequestMapping("/todoExpense/showIndex")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/todoExpense/showTodo")
    public String showTodo() {
        return "todo";
    }

    @RequestMapping("/todoExpense/showExpenses")
    public String showExpenses() {
        return "expenses";
    }



    /*

    @GetMapping("/login")
    public String showLogin(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "login";
    }

    */
}
