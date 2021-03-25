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
	public void read(int userNo) throws Exception;
	
	//insert
	public void register(Member member) throws Exception;
	
	//delete by userNo
	public void delete(int userNo) throws Exception;

	//update by userNo
	public void update(Member member) throws Exception;
}
