package com.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter{
	
	// ############  First way to achieve Security##############
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
		InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
		UserDetails user=User.withUsername("param").password(passwordEncoder.encode("1234")).authorities("read").build();
		userDetailsManager.createUser(user);
		
		auth.userDetailsService(userDetailsManager).passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}
**/
	// ##############  Second Way to achieve same things
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
		UserDetails user=User.withUsername("param").password(passwordEncoder.encode("1234")).authorities("read").build();
		userDetailsManager.createUser(user);
		
		auth.userDetailsService(userDetailsManager).passwordEncoder(passwordEncoder);
		// ##Note : here passwordEncoder is optional in line 48
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}
	
}
