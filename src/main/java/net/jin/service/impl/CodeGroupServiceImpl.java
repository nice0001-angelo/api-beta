/**
 * 
 */
package net.jin.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.jin.domain.*;
import net.jin.mapper.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */
@Service
public class CodeGroupServiceImpl implements CodeGroupService{

	@Autowired
	CodeGroupMapper codeGroupMapper;
	
	//select all
	@Override
	public List<CodeGroup> list() throws Exception {
		// TODO Auto-generated method stub
		return codeGroupMapper.list();
	}

	
	//select by id
	@Override
	public CodeGroup read(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		return codeGroupMapper.read(groupCode);
	}


	//create
	@Override
	public void register(CodeGroup codeGroup) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.create(codeGroup);
		
	}

	//delete
	@Override
	public void remove(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.delete(groupCode);
	}

	//update
	@Override
	public void modify(CodeGroup codeGroup) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.update(codeGroup);
		
	}
	

}
