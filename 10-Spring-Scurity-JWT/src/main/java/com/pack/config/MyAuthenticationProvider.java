package com.pack.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pack.entity.Users;
import com.pack.repo.UserRepo;

@Component
public class MyAuthenticationProvider implements UserDetailsService {

	@Autowired
private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repo.findByUserName(username);
		
		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
