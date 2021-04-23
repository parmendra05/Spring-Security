package com.pack;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String show() {
		return "<h1>Welcome to spring Boot RestController</h1>";
	}
	
	@RequestMapping("/h2")
	public String show2() {
		return "<h1>Welcome HR</h1>";
	}
	
	@RequestMapping("/d2")
	public String show3() {
		return "<h1>Welcome Developer</h1>";
	}
	
}
