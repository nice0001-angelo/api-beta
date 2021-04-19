/**
 * 
 */
package net.jin.common.security.domain;

import java.util.stream.*;

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
				.map(auth -> new SimpelGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	

}
