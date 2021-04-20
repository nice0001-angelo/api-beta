/**
 * 
 */
package net.jin.common.security.jwt.filter;

import java.util.stream.*;

import javax.servlet.http.*;

import org.springframework.security.authentication.*;
import org.springframework.security.core.*;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
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
 
	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
	
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		return authenticationManager.authenticate(authenticationToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain, Authentication authentication) {
		CustomUser customUser = ((CustomUser)authentication.getPrincipal());
		
		List<String> roles = customUser.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();
		
		String token = Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
				.setIssuer(SecurityConstants.TOKEN_ISSUER)
	}
}
