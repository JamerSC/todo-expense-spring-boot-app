package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(Integer theId);

    User save(User theUser);

    void deleteById(Integer theId);

}
