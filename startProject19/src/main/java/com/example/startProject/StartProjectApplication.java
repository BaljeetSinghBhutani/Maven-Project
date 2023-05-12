package com.example.startProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("dev")
public class StartProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(StartProjectApplication.class, args);
	}

}
