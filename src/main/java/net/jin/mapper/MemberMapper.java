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
	
	//List All
	public List<Member> list() throws Exception;

	//Read by userNo
	public Member read(int userNo) throws Exception;
	
	//insert
	public void create(Member member) throws Exception;
	
	//delete by userNo
	public void delete(int userNo) throws Exception;
	
	//update by userNo
	public void update(Member member) throws Exception;

}
