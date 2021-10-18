package com.tutorials.SadPod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SadPodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SadPodApplication.class, args);
	}

	@GetMapping(value = "/getMessage")
	public String sadMessage() {

		System.out.println("Inside sad message");
		return  "Hi, I am sad server";
	}
}
