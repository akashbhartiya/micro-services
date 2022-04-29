package com.example.ssldemoclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SsldemoclientApplication {
	
	@Autowired
	RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SsldemoclientApplication.class, args);
		
	}

	@GetMapping("/hi")
	public String Greet() {
		
		ResponseEntity<String> r =  restTemplate.getForEntity("https://localhost:9000/hello", String.class);
		return r.getBody();
		
	}
	
}
