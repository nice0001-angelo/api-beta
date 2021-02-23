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
public interface CodeDetailMapper {

	//등록
	public void create(CodeDetail codeDetail) throws Exception;
	
	//상세조회
	public CodeDetail read(CodeDetail codeDetail) throws Exception;

	//목록조회
	public List<CodeDetail> list() throws Exception;
	
	//수정
	public void update(CodeDetail codeDetail) throws Exception;
	
	//삭제
	public void delete(CodeDetail codeDetail) throws Exception;
	
	//Sort Seq number 가져오기
	public int getMaxSortSeq(String groupCode) throws Exception; 
	
}
