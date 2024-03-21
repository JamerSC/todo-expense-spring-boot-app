package com.jamersc.springboot.todoexpense;

import com.jamersc.springboot.todoexpense.dao.TodoexpenseDAO;
import com.jamersc.springboot.todoexpense.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

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

			//createUser(todoexpenseDAO);

			//createMultipleUser(todoexpenseDAO);

			//readUser(todoexpenseDAO);

			//queryForUsers(todoexpenseDAO);

			//queryForUsersForLastName(todoexpenseDAO);

			updateUser(todoexpenseDAO);

		};
	}

	private void updateUser(TodoexpenseDAO todoexpenseDAO) {

		// retrieve the users primary key
		int id = 1;
		System.out.println("Retrieving user id: " + id);
		User myUser = todoexpenseDAO.findById(id);

		//Print the User that will be updated
		System.out.println("User info: " + myUser);
		System.out.println("Updating user ...");

		// change the last name of user id 1
		System.out.println("Changing lastname from " + myUser.getLastName());
		myUser.setLastName("Doe");

		todoexpenseDAO.update(myUser);
		System.out.println("to " + myUser.getLastName());
		System.out.println();
		System.out.println();
		System.out.println("Updated user: " + myUser);


	}

	private void queryForUsersForLastName(TodoexpenseDAO todoexpenseDAO) {

		List<User> theUsers = todoexpenseDAO.findByLastName("Doe");

		for (User tempUser : theUsers) {
			System.out.println(tempUser);
		}
	}


	private void queryForUsers(TodoexpenseDAO todoexpenseDAO) {

		List<User> theUsers = todoexpenseDAO.findAll();

		for (User tempUser : theUsers) {
			System.out.println(tempUser);
		}

 	}

	private void readUser(TodoexpenseDAO todoexpenseDAO) {

		// Create a user
		System.out.println("Creating object ser");
		User tempUser = new User("Jane", "Doe", "janedoe", "jane123", "janedoe@yahoo.com");

		// save the user
		System.out.println("Saving a new user");
		todoexpenseDAO.save(tempUser);

		// display the id of saved user
		int theId = tempUser.getUserId();
		System.out.println("Saved user! Generated id: " + theId);
		User theUser = todoexpenseDAO.findById(theId);

		// retrieving user id based on the id: PK
		System.out.println("Retrieving the user id " + theUser);

	}

	private void createMultipleUser(TodoexpenseDAO todoexpenseDAO) {

		// create the user object
		System.out.println("Creating a multiple object users ...");
		User tempUser1 = new User("Mary", "Public", "marypublic", "mary123", "marypublic@mail.com");
		User tempUser2 = new User("Sam", "Smith","samsmith", "smith123", "samsmith@mail.com");
		User tempUser3 = new User("Puff", "Daddy", "puffdaddy", "puff123", "puffdaddy@mail.com" );

		// save the user object
		System.out.println("Saving the users");
		todoexpenseDAO.save(tempUser1);
		todoexpenseDAO.save(tempUser2);
		todoexpenseDAO.save(tempUser3);

		System.out.println("Saving 3 users!");

	}

	private void createUser(TodoexpenseDAO todoexpenseDAO) {

		// create the user object
		System.out.println("Creating a new object user ...");
		User tempUser = new User("John", "Doe", "johndoe", "john123", "johndoe@mail.com");

		// save the user object
		System.out.println("Saving the user");
		todoexpenseDAO.save(tempUser);

		// display the id of saved student

		System.out.println("Saved user. generated id: " + tempUser.getUserId());
		System.out.println("Username: " + tempUser.getUsername());
		System.out.println("Created by: " + tempUser.getCreatedBy());
		System.out.println("Created date: " + tempUser.getCreatedDate());

	}

}
