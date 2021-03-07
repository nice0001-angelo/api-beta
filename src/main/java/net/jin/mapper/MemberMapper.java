/**
 * 
 */
package net.jin.mapper;

import java.util.*;

import net.jin.domain.*;

/**
 * @author njh
 *
 */
public interface MemberMapper {
	
	//목록조회
	public List<Member> list() throws Exception;

}
