package com.tutorials.my.docker.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class HappyAppApplication {

	public static int counter = 0;

	public static void main(String[] args) {
		SpringApplication.run(HappyAppApplication.class, args);
	}

	@GetMapping(value = "/")
	public String counter(){
		System.out.println("Inside HappyAppApplication " + counter);
		counter = counter + 1;
		return "Welcome to happy application " + "number of hits " + counter;
	}


	@GetMapping(value = "/getMessage")
	public String happyMessage() {
		System.out.println("Returning happy message");
		return "Hi, I am happy server";
	}

}
