package com.pack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pack.dao.MyDao;
import com.pack.entity.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MyDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user=dao.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found" +username));
        return  user.map(MyUserDetails::new).get();
	}

}
