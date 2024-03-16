package com.jamersc.springboot.todoexpense;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoexpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoexpenseApplication.class, args);
	}

	@Bean
	// springboot framework
	public CommandLineRunner commandLineRunner(String[] args) {

		// lambda expression - custom code
		return  runner -> {
			System.out.println("Hello world!");
		};
	}
}
