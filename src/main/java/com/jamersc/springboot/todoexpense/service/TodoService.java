package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAllTodo();

    Todo findTodoById(Integer id);

    void saveTodo(Todo todo);

    void deleteTodoById(Integer id);
}
