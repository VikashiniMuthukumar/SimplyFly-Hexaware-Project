package com.hexaware.simplyfly.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class HomeController {
	@GetMapping("/")
	public String sayHello() {
		return "Hello Friends , Welcome back";

	}

	 @GetMapping("/secure")
	    public ResponseEntity<Void> redirectToSwagger() {
	        return ResponseEntity.status(HttpStatus.FOUND)
	                .location(ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/swagger-ui/index.html")
	                .build().toUri())
	                .build();
	    }
}
