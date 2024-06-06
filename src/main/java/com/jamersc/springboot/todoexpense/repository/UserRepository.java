package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Spring data JPA
    // Custom repository implementation
    User findByUsernameAndPassword(String username, String password);
}
