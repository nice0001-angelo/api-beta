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
	
	@Override
	public UserDeatails loadUserByUsername(String userName) throws UsernameNotFoundException{
		log.info("userName: "+userName);
		
		Member mebmer = memberMapper.readByUserId(userName);
	}
	
}
