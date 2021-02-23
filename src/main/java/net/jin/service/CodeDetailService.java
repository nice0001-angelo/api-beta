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

	//등록
	public void register(CodeDetail codeDetail) throws Exception;
	
	//상세조회
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	
	//목록조회
	public List<CodeDetail> list() throws Exception;
	
	//수정
	public void modify(CodeDetail codeDetail) throws Exception;
	
	//삭제
	public void remove(CodeDetail codeDetail) throws Exception;
}
