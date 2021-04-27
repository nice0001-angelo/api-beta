/**
 * 
 */
package net.jin.mapper;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import net.jin.domain.*;

/**
 * @author njh
 *
 */
public interface MemberMapper {
	
	//사용자 ID로 회원정보 조회. CustomUserDetailsService에서 memberMapper.readByUserId(userName)로 호출하기 때문에 뒤에 throws Exception을 붙이면 에러가 남
	public Member readByUserId(String userId);
	
	//List All
	public List<Member> list() throws Exception;

	//Read by userNo
	public Member read(int userNo) throws Exception;
	
	//insert Member
	public void create(Member member) throws Exception;
	
	//delete by userNo
	public void delete(int userNo) throws Exception;
	
	//update by userNo
	public void update(Member member) throws Exception;
	
	//insert Auth
	public void createAuth(MemberAuth memberAuth) throws Exception;

	//deleteAuth by userNo
	public void deleteAuth(int userNo) throws Exception;

}
