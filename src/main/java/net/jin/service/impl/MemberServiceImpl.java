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
		
		System.out.println("MemberServiceImpl register(Member member) ==> member: "+member);
		
		memberMapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_MEMBER");
		
		System.out.println("MemberServiceImpl register(Member member) ==> memberAuth: "+memberAuth);
		
		memberMapper.createAuth(memberAuth);
		
		
	}
	
	//delete by userNo
	@Transactional
	@Override
	public void remove(int userNo) throws Exception{
		System.out.println("MemberServiceImpl delete by userNo: "+userNo);
		
		memberMapper.deleteAuth(userNo);
		memberMapper.delete(userNo);
	}
	
	//update by unserNo
	@Transactional
	@Override
	public void modify(Member member) throws Exception{
		System.out.println("MemberServiceImpl update Member: "+member);
		memberMapper.update(member);
		
		//회원권한 수정
		int userNo = member.getUserNo();
		
		memberMapper.deleteAuth(userNo);
		
		List<MemberAuth> memberAuthList = member.getMemberAuthList();
		
		System.out.println("MemberServiceImpl update memberAuthList: "+memberAuthList );
		
		for(int i =0; i < memberAuthList.size(); i++) {
			MemberAuth memberAuth = memberAuthList.get(i);
			
			String auth = memberAuth.getAuth();
			
			if(auth == null) {
				continue;
			}
			
			if(auth.trim().length() == 0) {
				continue;
			}
			
			memberAuth.setUserNo(userNo);
			
			memberMapper.createAuth(memberAuth);
		}
	}
	
	//회원 테이블의 데이터 건수를 반환한다
	@Override
	public int countAll() throws Exception {
		return memberMapper.countAll();
	}

	@Transactional
	@Override
	public void setupAdmin(Member member) throws Exception {
		memberMapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		
		memberAuth.setAuth("ROLE_ADMIN");
		
		memberMapper.createAuth(memberAuth);
		
	}
	
}

