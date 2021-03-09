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

	//목록조회  List
	public List<Member> list() throws Exception;
	
	
	//상세조회 Read
	public Member read(@PathVariable("userNo") int userNo) throws Exception;

}
