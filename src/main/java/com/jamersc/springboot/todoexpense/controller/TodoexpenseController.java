package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoexpenseController {

    // Show form & Create a model
    @GetMapping("/showLogin")
    public String showLogin(Model model) {
        // create a user object
        User user = new User();
        // create a model
        model.addAttribute("user", user);
        // redirect to login page
        return "login";
    }

    @PostMapping("/processLoginForm")
    public String processLoginForm(@ModelAttribute("user") User theUser){

        //log input data
        System.out.println("theUser username: " + theUser.getUsername());

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

    @GetMapping("/showIndex")
    public String showIndex() {
        return "index";
    }

    @GetMapping("showTodo")
    public String showTodo() {
        return "todo";
    }

    @GetMapping("/showExpenses")
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
