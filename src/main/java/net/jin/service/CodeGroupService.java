/**
 * 
 */
package net.jin.service;

import java.util.*;

import net.jin.domain.*;

/**
 * @author njh
 *
 */
public interface CodeGroupService {
	
	//상세조회
	public CodeGroup read(String groupCode) throws Exception;
	
	//목록조회
	public List<CodeGroup> list() throws Exception;

	//등록
	public void register(CodeGroup codeGroup) throws Exception;
	
	//수정
	public void modify(CodeGroup codeGroup) throws Exception;
	
	//삭제
	public void remove(String groupCode) throws Exception;
	


}
