package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;

import java.util.List;

public interface TodoexpenseDAO {

    void save(User theUser);

    User findById(Integer id);

    List<User> findAll();

    List<User> findByLastName(String theLastName);
}
