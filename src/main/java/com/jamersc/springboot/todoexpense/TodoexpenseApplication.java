package com.jamersc.springboot.todoexpense;

import com.jamersc.springboot.todoexpense.dao.TodoexpenseDAO;
import com.jamersc.springboot.todoexpense.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TodoexpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoexpenseApplication.class, args);
	}

	@Bean
	// springboot framework
	public CommandLineRunner commandLineRunner(TodoexpenseDAO todoexpenseDAO) {

		// lambda expression - custom code
		return  runner -> {
			// System.out.println("Hello world!");
			createUser(todoexpenseDAO);
		};
	}

	private void createUser(TodoexpenseDAO todoexpenseDAO) {

		// create the user object
		System.out.println("Creating a new object user ...");
		User tempUser = new User("johndoe", "john123", "johndoe@mail.com");

		// save the user object
		System.out.println("Saving the user");
		todoexpenseDAO.save(tempUser);

		// display the id of saved student
		System.out.println("Saved user. generated id: " + tempUser.getUserId());
	}
}
