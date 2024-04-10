package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // Show form & Create a model
    @GetMapping("/showLogin")
    public String showLogin(Model model) {
        // display the date
        model.addAttribute("theDate", java.time.LocalDateTime.now());
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

       // return "redirect:/users/index";
         return "index";
    }

    @PostMapping("/processCreateAccount")
    public String processCreateAccount(@ModelAttribute("newUsername") String newUsername,
                                       @ModelAttribute("newPassword") String newPassword,
                                       Model model) {

        User newUser = new User();

        newUser.setUsername(newUsername);
        newUser.setPassword(newPassword);

        System.out.println("New username: " + newUser.getUsername());

        model.addAttribute("newUser", newUser);


        return "newUserPage";
    }

    @GetMapping("/showNewUser")
    public String showNewUser(Model model) {
        // You can add other attributes if needed
        return "newUserPage"; // This is the HTML page where you want to display newUser.Username
    }

    /* Index/Dashboard Page */
    @GetMapping("/showIndex")
    public String showIndex() {
        return "index";
    }


    // Http Servlet Process
    /*
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
     */

    // Request Param Annotation
    /*
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
     */

    /*

    @GetMapping("/login")
    public String showLogin(Model theModel) {

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "login";
    }

    */

}
