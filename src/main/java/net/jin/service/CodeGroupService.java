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
	

	//select all
	public List<CodeGroup> list() throws Exception;
	
	//select by id
	public CodeGroup read(String groupCode) throws Exception;
	
	//create
	public void register(CodeGroup codeGroup) throws Exception;
	
	//delete by id
	public void remove(String groupCode) throws Exception;
	
	//update
	public void modify(CodeGroup codeGroup) throws Exception;
	

	


}
