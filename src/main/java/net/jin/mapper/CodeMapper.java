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

}
