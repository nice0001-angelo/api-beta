/**
 * 
 */
package net.jin.common.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;

import lombok.extern.java.*;
import net.jin.common.security.domain.*;
import net.jin.domain.*;
import net.jin.mapper.*;

/**
 * @author njh
 *
 */
@Log
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public MemberMapper memberMapper;
	
	//사용자정보조회
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("userName : " + userName);

		Member member = memberMapper.readByUserId(userName);

		log.info("member : " + member);

		return member == null ? null : new CustomUser(member);
	} 
}
