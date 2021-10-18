package com.example.MessageControllerPod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class MessageControllerPodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageControllerPodApplication.class, args);
	}


	@GetMapping("/getMyMessage/{type}")
	public String getMessagesByType(@PathVariable(value = "type") String messageType) {

		System.out.println("Inside getMessagesByType with value " + messageType);
		if(messageType.equalsIgnoreCase("HappyMessage")) {
			return getMessageFromService("happy-container","9090");
		}else {
			return  getMessageFromService("sad-container","9091");

		}
	}

	private String getMessageFromService(String serviceName,String port){

		RestTemplate restTemplate = new RestTemplate();
		String serviceUrl = "http://" + serviceName +":"+port+"/getMessage";
		System.out.println("Service url "+ serviceUrl);

		ResponseEntity<String> response
				= restTemplate.getForEntity(serviceUrl , String.class);
		return response.getBody();
	}
}
