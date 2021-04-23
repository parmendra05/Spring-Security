package com.pack;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("param")
		.password("12345")
		.roles("Developer")
		.and()
		.withUser("hr")
		.password("12345")
		.roles("HR");
	}
	
	
	  @Bean public PasswordEncoder getpassword() { return
	  NoOpPasswordEncoder.getInstance(); }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		//.antMatchers("/").hasRole("HR")
		.antMatchers("/h2").hasRole("HR")
		.antMatchers("/d2").hasRole("Developer")
		.and().formLogin();
		
	}
	 

}
