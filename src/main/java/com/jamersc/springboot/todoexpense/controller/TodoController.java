package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;

@Controller
public class TodoController {

    //@Value("${todo_status}")
    //private List<String> todoStatuses;

    /* To do page*/
    @GetMapping("/showTodo")
    public String showTodo(Model model) {

        model.addAttribute("message", "Create a new todo!");
        // New to do object
        //Todo todo = new Todo();

        // create a model
        //model.addAttribute("todo", todo);

        // model for status
        //model.addAttribute("todoStatuses", todoStatuses);

        // redirect to do page
        return "todo";
    }

    @GetMapping("/showTodoForm")
    public String showTodoForm(Model model) {

        model.addAttribute("todo", new Todo());

        return "todo-form";
    }

    @PostMapping("/createTodo")
    public String createTodo(@ModelAttribute("todo") Todo todo, Model model) {
        // Print values for debugging
        System.out.println("Todo title: " + todo.getTodoName());
        System.out.println("Todo details: " + todo.getTodoDetails());
        System.out.println("Todo details: " + todo.getTodoStartDate());
        System.out.println("Todo details: " + todo.getTodoStartDate());
        System.out.println("Todo status: " + todo.getTodoStatus());

        // You can save the todo object or perform other operations here
        // Add the todo object to the model
        model.addAttribute("todo", todo);

        // Redirect to a suitable page
        return "todo";
    }

}
