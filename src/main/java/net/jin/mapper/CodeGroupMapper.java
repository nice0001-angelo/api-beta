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
public interface CodeGroupMapper {
	
	//상세조회
	public CodeGroup read(String groupCode) throws Exception;
	
	//목록조회
	public List<CodeGroup> list() throws Exception;
	
	//
	
	
	
	
}
