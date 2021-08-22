package com.gcu;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
public class SecurityConfig {
	
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.antMatcher("/**")
			.authorizeRequests()
				.antMatchers("/", "/login**", "/callback/", "/error**").permitAll()
			.anyRequest()
				.authenticated();
	}

}
