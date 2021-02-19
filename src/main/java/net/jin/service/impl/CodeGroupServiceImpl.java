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
	
	//상세조회
	@Override
	public CodeGroup read(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		return codeGroupMapper.read(groupCode);
	}

	//목록조회
	@Override
	public List<CodeGroup> list() throws Exception {
		// TODO Auto-generated method stub
		return codeGroupMapper.list();
	}

	//등록
	@Override
	public void register(CodeGroup codeGroup) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.create(codeGroup);
		
	}

	//수정
	@Override
	public void modify(CodeGroup codeGroup) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.update(codeGroup);
		
	}
	
	//삭제
	@Override
	public void remove(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		codeGroupMapper.delete(groupCode);
	}

}
