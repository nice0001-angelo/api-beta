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
	
	public List<CodeLabelValue> getCodeGroupList(String codeGroup) throws Exception;
}
