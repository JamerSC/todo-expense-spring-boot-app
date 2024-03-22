package com.jamersc.springboot.todoexpense.controller;


import com.jamersc.springboot.todoexpense.dao.UserRepository;
import com.jamersc.springboot.todoexpense.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@Controller
@RequestMapping("/todoexpense")
public class RestController {

    // Using JpaRepository for Accessing DB & test API
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // testing REST API in postman
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Start recording your work now!";
    }

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
