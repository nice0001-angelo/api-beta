/**
 * 
 */
package net.jin.common.security.jwt.filter;

import net.jin.common.security.jwt.constants.*;

/**
 * @author njh
 *
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	

	private final AuthenticationManager authenticationManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager = authenticationManager;
		
		setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
	}
 

}
