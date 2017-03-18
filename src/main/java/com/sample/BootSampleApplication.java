package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootSampleApplication {

	@RequestMapping("/")
	String sayHello() {
		return "Hello Spring Boot World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(BootSampleApplication.class, args);
	}
}
