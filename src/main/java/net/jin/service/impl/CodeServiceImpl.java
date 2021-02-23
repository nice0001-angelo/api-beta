/**
 * 
 */
package net.jin.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.jin.common.domain.*;
import net.jin.mapper.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */
@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	private CodeMapper codeMapper;

	//그룹코드목록조회
	@Override
	public List<CodeLabelValue> getCodeGroupList() throws Exception {
		// TODO Auto-generated method stub
		return codeMapper.getCodeGroupList();
	}
	
	 
}
