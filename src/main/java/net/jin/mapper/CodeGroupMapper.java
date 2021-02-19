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
	
	//등록
	public void create(CodeGroup codeGroup) throws Exception;
	
	//수정
	public void update(CodeGroup codeGroup) throws Exception;
	
	//삭제
	public void delete(String groupCode) throws Exception;
	
}
