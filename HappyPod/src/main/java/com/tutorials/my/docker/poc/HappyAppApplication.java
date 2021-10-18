package com.tutorials.my.docker.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HappyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyAppApplication.class, args);
	}

	@GetMapping(value = "/getMessage")
	public String happyMessage() {
		System.out.println("Inside happy message");
		return "Hi, I am happy server";
	}

}
