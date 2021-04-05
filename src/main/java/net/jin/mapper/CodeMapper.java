/**
 * 
 */
package net.jin.mapper;

import java.util.*;

import net.jin.common.domain.*;

/**
 * @author njh
 *
 */
public interface CodeMapper {
	
	//그룹코드목록조회
	public List<CodeLabelValue> getCodeGroupList() throws Exception;
	
	//지정된 그룹코드 목록 조회
	public List<CodeLabelValue> getCodeGroupList(String codeGroup) throws Exception;

}
