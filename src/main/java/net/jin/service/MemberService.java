/**
 * 
 */
package net.jin.service;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import net.jin.domain.*;

/**
 * @author njh
 *
 */
public interface MemberService {

	//List all
	public List<Member> list() throws Exception;
	
	//Read by userNo
	public Member read(int userNo) throws Exception;
	
	//insert all
	public void register(Member member) throws Exception;
	
	//delete by userNo
	public void remove(int userNo) throws Exception;

	//update by userNo
	public void modify(Member member) throws Exception;
	
	//countAll 회원테이블의 데이터컨수를 반환한다
	public int countAll() throws Exception;

	//setupAdmin 최초관리자 생성을 위한 데이터를 등록한다
	public void setupAdmin(Member member) throws Exception;


}
