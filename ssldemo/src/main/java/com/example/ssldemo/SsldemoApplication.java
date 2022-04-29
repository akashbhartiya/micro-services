package com.example.ssldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SsldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsldemoApplication.class, args);
	}

	
	@GetMapping("/hello")
	public String greet() {
		return "!! Hello World !!";
	}
}
