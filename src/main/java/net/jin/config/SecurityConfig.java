/**
 * 
 */
package net.jin.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.cors.*;

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
		httpSecurity.cors()
		.and()
		//CSRF 방지 지원 기능 비활성화
		.csrf().disable()
		//JWT 인증 필터 보안 컨텍스트에 추가
		.addFilter(new JwtAuthenticationFilter(authenticationManager()))
		//JWT 인가 필터 보안 컨텍스트에 추가
		.addFilter(new JwtAuthorizationFilter(authenticationManager()))
		//세션 관리 비활성화
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
	//CustomUserDetailsService 빈을 인증 제공자에게 지정하고 비밀번호 암호처리기를 등록한다
		authenticationManagerBuilder.userDetailsService(createUserDetailsService())
		.passwordEncoder(createPasswordEncoder());
	}
	
	//비밀번호 암호처리기 생성(빈으로 등록한다)
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	//CORS 설정
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		
	}
	
	
}
