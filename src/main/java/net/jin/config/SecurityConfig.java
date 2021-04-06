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
		
		//스프링 Security 설정

		//CORS 설정
		httpSecurity.cors();
		
		//CSRF 방지 지원 기능 비활성화
		httpSecurity.csrf().disable();
		
		//
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
	
	}
	
	//비밀번호 암호처리기 생성
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
