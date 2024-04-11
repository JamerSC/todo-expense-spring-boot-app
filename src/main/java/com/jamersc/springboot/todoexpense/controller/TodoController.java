package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    /* To do page*/
    @GetMapping("/showTodo")
    public String showTodo(Model model) {

        // New to do object
        Todo todo = new Todo();
        // create a model
        model.addAttribute("todo", todo);
        // redirect to do page
        return "todo";
    }

    @PostMapping("/createTodo")
    public String createTodo() {

        return "todo";
    }

}
