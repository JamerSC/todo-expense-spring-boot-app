package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.Todo;

import java.util.List;

public interface TodoDao {

    Todo findById(Integer id);

    List<Todo> findAll();

    void save(Todo todo);

    void update(Todo todo);

    void deleteById(Integer id);

}
