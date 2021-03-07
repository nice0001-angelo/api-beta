/**
 * 
 */
package net.jin.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.jin.service.*;

/**
 * @author njh
 *
 */
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	//목록조회
	public List<Member> list() throws Exception{
		return memberMapper.list();
	}
}
