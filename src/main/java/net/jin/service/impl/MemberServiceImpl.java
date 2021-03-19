/**
 * 
 */
package net.jin.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import net.jin.domain.*;
import net.jin.mapper.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	//List all
	@Override
	public List<Member> list() throws Exception{
		System.out.println("MemberService Impl list: "+memberMapper.list());
		return memberMapper.list();
	}

	//Read by userNo
	@Override
	public Member read(@PathVariable("userNo") int userNo) throws Exception {
		System.out.println("MemberServiceImpl userNo: "+userNo);
		System.out.println("MemberServiceImpl memberMapper.read(userNo): "+memberMapper.read(userNo));
		return memberMapper.read(userNo);
	}
	
	//insert all
	@Override
	public void register(Member member) throws Exception{
		memberMapper.create(member);
	}
	
	//delete by userNo
	@Override
	public void delete(int userNo) throws Exception{
		System.out.println("MemberServiceImpl delete by userNo: "+userNo);
		memberMapper.delete(userNo);
	}
}
