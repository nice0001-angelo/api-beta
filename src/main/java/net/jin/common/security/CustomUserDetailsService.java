/**
 * 
 */
package net.jin.common.security;

import org.springframework.beans.factory.annotation.*;

import lombok.extern.java.*;
import net.jin.mapper.*;

/**
 * @author njh
 *
 */
@Log
public class CustomUserDetailsService extends UserDatailsService {

	@Autowired
	public MemberMapper memberMapper;
	
	//사용자정보조회
	@Override
	public UserDeatails loadUserByUsername(String userName) throws UsernameNotFoundException{
		log.info("userName: "+userName);
		
		Member mebmer = memberMapper.readByUserId(userName);
		
		log.info("member: "+member);
		
		return member == null ? null : new CustomUser(member);
		log.info("member: "+member);
	}
	
}
