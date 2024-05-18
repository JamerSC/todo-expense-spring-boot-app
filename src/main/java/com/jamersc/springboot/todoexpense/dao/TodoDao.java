package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.Todo;

import java.util.List;

public interface TodoDao {

    Todo findById(Integer id);

    List<Todo> findAll();

    void save(Todo todo);

    void update(Todo todo);

    void deleteById(Integer id);

}
