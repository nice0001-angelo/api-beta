/**
 * 
 */
package net.jin.common.security.jwt.filter;

import org.mybatis.logging.*;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.www.*;

/**
 * @author njh
 *
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	
	private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

}
