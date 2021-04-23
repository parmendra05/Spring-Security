package com.pack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String defUser() {
		return "Welcome to Home Page ,Thanks for login";
	}
	@GetMapping("/user")
	public String user() {
		return "Welcome user ,Thanks for login";
	}
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin ,Thanks for login";
	}

}
