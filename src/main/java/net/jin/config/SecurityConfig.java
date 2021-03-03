/**
 * 
 */
package net.jin.config;

import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

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
}
