/**
 * 
 */
package net.jin.common.security.jwt.constants;

/**
 * @author njh
 *
 */
public class SecurityConstants {
	//로그인 인증 URL 정의
	public static final String AUTH_LOGIN_URL ="/api/authenticate";
	
	//HS512 암화와 알고리즘 서명키 정의
	public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";
	
	//JWT 토큰 기본 상수값 정의
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String TOKEN_TYPE = "JWT";
	public static final String TOKEN_ISSUER = "secure-api";
	public static final String TOKEN_AUDIENCE = "secure-app";

}
