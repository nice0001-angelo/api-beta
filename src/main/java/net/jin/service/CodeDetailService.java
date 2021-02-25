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
public interface CodeDetailService {



	//목록조회 List
	public List<CodeDetail> list() throws Exception;
	
	//상세조회  Read
	public CodeDetail read(CodeDetail codeDetail) throws Exception;

	//등록 Register
	public void register(CodeDetail codeDetail) throws Exception;
	
	//삭제 Delete
	public void remove(CodeDetail codeDetail) throws Exception;	
	
	//수정 Modify
	public void modify(CodeDetail codeDetail) throws Exception;
	

}
