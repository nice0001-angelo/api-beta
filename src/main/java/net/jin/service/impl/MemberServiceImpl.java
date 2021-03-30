/**
 * 
 */
package net.jin.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
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
	@Transactional
	@Override
	public void register(Member member) throws Exception{
		memberMapper.create(member);
	}
	
	//delete by userNo
	@Transactional
	@Override
	public void remove(int userNo) throws Exception{
		System.out.println("MemberServiceImpl delete by userNo: "+userNo);
		memberMapper.delete(userNo);
	}
	
	//update by unserNo
	@Transactional
	@Override
	public void modify(Member member) throws Exception{
		System.out.println("MemberServiceImpl update Member: "+member);
		memberMapper.update(member);
	}
}

