/**
 * 
 */
package net.jin.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

import lombok.extern.java.*;

/**
 * @author njh
 *
 */
@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		log.info("Security Configuring....");
		
		//CSRF 방지 지원 기능 활성화
		httpSecurity.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
	}
	
	/*
	 * @Bean public PasswordEncoder createPasswordEncoder{
	 * 
	 * return new BCryptPasswordEncoder();
	 * 
	 * }
	 */
}
