package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Spring data JPA
}
