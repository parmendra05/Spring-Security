package com.pack;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pack.entity.Users;
import com.pack.repo.UserRepo;

@SpringBootApplication
public class Application {

	@Autowired
	private UserRepo repo;
	
	@PostConstruct
	public void initMethod() {
		List<Users> user=new ArrayList<>();
		user.add(new Users(1, "user", "user"));
		user.add(new Users(2, "admin", "admin"));
		repo.saveAll(user);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
