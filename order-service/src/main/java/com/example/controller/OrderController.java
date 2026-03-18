package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final RestTemplate restTemplate = new RestTemplate();
	private final String USER_SERVICE_URL = "http://user-service:8080/users";

	@GetMapping
	public List<String> getOrder() {
		List<String> users = restTemplate.getForObject(USER_SERVICE_URL, List.class);

		return users.stream().map(u -> u + "'s Order").toList();
	}

	
	// END POINT : http://localhost:8881/
	
}
