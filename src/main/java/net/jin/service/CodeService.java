/**
 * 
 */
package net.jin.service;

import java.util.*;

import net.jin.common.domain.*;

/**
 * @author njh
 *
 */
public interface CodeService {

	public List<CodeLabelValue> getCodeGroupList() throws Exception;
	
	//지정된 코드그룹의 상세 코드 목록 조회
	public List<CodeLabelValue> getCodeGroupList(String codeGroup) throws Exception;
}
