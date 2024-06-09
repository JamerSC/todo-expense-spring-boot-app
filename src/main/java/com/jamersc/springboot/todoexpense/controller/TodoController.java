package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.dto.ManageTodo;
import com.jamersc.springboot.todoexpense.model.Todo;
import com.jamersc.springboot.todoexpense.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /* To do page*/
    @GetMapping("/todo")
    public String showTodo(Model model) {
        List<Todo> todos = todoService.findAllTodo();
        model.addAttribute("todo", todos);
        // console log display all task
        for (Todo tempTodo : todos) {
            System.out.println(tempTodo);
        }
        return "todo-expense/todo";
    }

    @GetMapping("/createTodo")
    public String showTodoForm(Model model) {
        model.addAttribute("todo", new ManageTodo());
        return "./forms/todo-form";
    }

    @PostMapping("/createTodo")
    public String createTodo(@Valid @ModelAttribute("todo") ManageTodo createTodo,
                             BindingResult result, Model model) {
        System.out.println("Create Todo: " + createTodo);
        if (result.hasErrors()) {
            return "./forms/todo-form";
        } else {
            todoService.saveTodo(createTodo);
            return "redirect:/todos/todo";
        }

    }

    @GetMapping("/updateTodo")
    public String updateTodo(@RequestParam("todoId") Integer todoId, Model model) {
        ManageTodo manageTodo = todoService.findTodoById(todoId);
        if (manageTodo != null) {
            model.addAttribute("todo", manageTodo);
            return "./forms/todo-update-form";
        }
        return "redirect:/todos/todo";
    }

    @PostMapping("/updateTodo")
    public String processUpdateTodo(@Valid @ModelAttribute("todo") ManageTodo updateTodo,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "./forms/todo-update-form";
        } else {
            ManageTodo manageTodo = todoService.findTodoById(updateTodo.getId());
            if (manageTodo != null) {
                todoService.saveTodo(updateTodo);
            }
            return "redirect:/todos/todo";
        }
    }


    @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("todoId") Integer id, Model model) {
        todoService.deleteTodoById(id);
        return "redirect:/todos/todo";

    }

}
