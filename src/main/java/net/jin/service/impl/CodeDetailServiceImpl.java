/**
 * 
 */
package net.jin.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.jin.domain.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */
@Service
public class CodeDetailServiceImpl implements CodeDetailService{

	@Autowired
	private CodeDetailMapper codeDetailMapper;
	
	//등록
	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		String groupCode = codeDetail.getGroupCode();
		codeDetailMapper.get
		
	}

	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeDetail> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
