package com.jamersc.springboot.todoexpense.controller;


import com.jamersc.springboot.todoexpense.dao.UserRepository;
import com.jamersc.springboot.todoexpense.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
//@Controller
@RequestMapping("/todoexpense")
public class RestController {

    // Using JpaRepository for Accessing DB & test API

    private final UserRepository userRepository;

    @Autowired
    public RestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable int userId) {

        Optional<User> theUser = userRepository.findById(userId);

        if(theUser.isEmpty()) {
            throw new UserNotFoundException("The User id not found - " + userId);
        }

        return theUser;

    }

    // Exception handler
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {

        // Create user error response
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Bad Request
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exc) {

        // Create user error response
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


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
