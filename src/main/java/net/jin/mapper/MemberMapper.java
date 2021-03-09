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
	
	//목록조회 List
	public List<Member> list() throws Exception;

	//상세목록조회 Read
	public Member read(int userNo) throws Exception;

}
