/**
 * 
 */
package net.jin.common.util;

import io.jsonwebtoken.*;
import net.jin.common.security.jwt.constants.*;

/**
 * @author njh
 *
 */
public class AuthUtil {

	//JWT 헤더값을 해석하여 사용자번호 획득
	public static int getUserNo(String header) throws Exception{
		String token = header.substring(7);
		
		byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();
		
		Jws<Claims> parseToken = Jwts.parser()
				.setSigningKey(signingKey)
				.parseClaimsJws(token);
		
	}
}
