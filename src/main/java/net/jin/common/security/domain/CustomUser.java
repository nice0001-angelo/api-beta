/**
 * 
 */
package net.jin.common.security.domain;

import java.util.*;
import java.util.stream.*;

import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;

import net.jin.domain.*;

/**
 * @author njh
 *
 */
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		
		super(username, password, authorities);
		
	}
	
	public CustomUser(Member member) {
		super(member.getUserId(), member.getUserPw(), member.getMemberAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	

}
