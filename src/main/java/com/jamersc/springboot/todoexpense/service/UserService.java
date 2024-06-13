package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dto.LoginUser;
import com.jamersc.springboot.todoexpense.dto.ManageUser;
import com.jamersc.springboot.todoexpense.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User loginUser(LoginUser loginUser);

    User manageUser(ManageUser manageUser);

    List<User> findAllUser();

    ManageUser findUserById(Integer id);

    void saveUser(ManageUser manageUser);

    void deleteUserById(Integer id);

}
