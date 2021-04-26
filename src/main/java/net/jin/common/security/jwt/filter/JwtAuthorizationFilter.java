/**
 * 
 */
package net.jin.common.security.jwt.filter;

import java.io.*;
import java.util.stream.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.mybatis.logging.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.www.*;

import io.jsonwebtoken.*;
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
		if(isNotEmpty(token)) {
			try {
				byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();
				
				Jws<Claims> parsedToken = Jwts.parser()
						.setSigningKey(signingKey)
						.parseClaimsJws(token.replace("Bearer", ""));
				
				String username = parsedToken.getBody().getSubject();
				
				List<SimpleGrantedAuthority> authorities = ((List<?>)parsedToken.getBody()
						.get("rol"))
						.stream()
						.map(authority -> new SimpleGrantedAuthority((String) authority))
						.collect(Collectors.toList());
				if(isNotEmpty(username)) {
					return new UsernamePasswordAuthenticationToken(username, null, authorities);
					
				}

						
			} catch (ExpiredJwtException exception) {
				log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
			} catch (UnsupportedJwtException exception) {
				log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
			} catch (MalformedJwtException exception) {
				log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
			} catch (SignatureException exception) {
				log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
			} catch (IllegalArgumentException exception) {
				log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
			}
		}
		
		return null;
	}
	
	private boolean isEmpty(final CharSequence charSequence) {
		return charSequence == null || charSequence.length() == 0;
	}
	
	private boolean isNotEmpty(final CharSequence charSequence) {
		return !isEmpty(charSequence);
	}
	
}
