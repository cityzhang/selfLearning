package com.example.selfProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})

public class SelfProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfProjectApplication.class, args);
	}

}
