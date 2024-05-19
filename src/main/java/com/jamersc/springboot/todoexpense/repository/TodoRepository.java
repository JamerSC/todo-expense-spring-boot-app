package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    //JPA custom queries
}
