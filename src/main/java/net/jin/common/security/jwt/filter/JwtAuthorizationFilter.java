/**
 * 
 */
package net.jin.common.security.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.mybatis.logging.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.www.*;

import net.jin.common.security.jwt.constants.*;

/**
 * @author njh
 *
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	
	private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException{
		Authentication authentication = getAuthentication(httpServletRequest);
		
		String header = httpServletRequest.getHeader(SecurityConstants.TOKEN_HEADER);
		
		if(isEmpty(header)||!header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader(SecurityConstants.TOKEN_HEADER);
	}
}
