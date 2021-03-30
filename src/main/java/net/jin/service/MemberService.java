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
	
	//insert
	public void register(Member member) throws Exception;
	
	//delete by userNo
	public void remove(int userNo) throws Exception;

	//update by userNo
	public void modify(Member member) throws Exception;
}
