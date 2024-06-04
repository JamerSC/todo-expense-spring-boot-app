package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.model.Todo;
import com.jamersc.springboot.todoexpense.dto.ManageTodo;
import com.jamersc.springboot.todoexpense.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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

        // Display all todo
        List<Todo> todos = todoService.findAllTodo();

        model.addAttribute("todo", todos);

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
        }
        else {

            Todo todo = new Todo();

            BeanUtils.copyProperties(createTodo, todo);

            // Save todo
            todoService.saveTodo(todo);

            model.addAttribute("todo", todo);

            return "redirect:/todos/todo";
        }

    }

    @GetMapping("/updateTodo")
    public String updateTodo(@RequestParam("todoId") Integer todoId, Model model) {

        Todo todo = todoService.findTodoById(todoId);

        model.addAttribute("todo", todo);

        return "./forms/todo-update-form";
    }

    @PostMapping("/updateTodo")
    public String processUpdateTodo(@Valid @ModelAttribute("todo") ManageTodo updateTodo,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "./forms/todo-update-form";
        }
        else {

            Todo todo = todoService.findTodoById(updateTodo.getId());

            if (todo != null) {

                BeanUtils.copyProperties(updateTodo, todo);

                todoService.saveTodo(todo);

                return "redirect:/todos/todo";
            }
        }

        return "redirect:/todos/todo";
    }


    @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("todoId") Integer id, Model model) {

        todoService.deleteTodoById(id);

        return "redirect:/todos/todo";

    }

}
