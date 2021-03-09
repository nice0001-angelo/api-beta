/**
 * 
 */
package net.jin.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

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
	
	//목록조회
	@Override
	public List<Member> list() throws Exception{
		System.out.println("MemberService Impl list: "+memberMapper.list());
		return memberMapper.list();
	}

	@Override
	public Member read(int userNo) throws Exception {
		System.out.println("MemberServiceImpl userNo: "+userNo);
		System.out.println("MemberServiceImpl Member: "+memberMapper.read(userNo));
		return memberMapper.read(userNo);
	}
}