/**
 * 
 */
package net.jin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
import net.jin.domain.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */

@Log
@RestController
@RequestMapping("/codedetails")
public class CodeDetailController {
	
	@Autowired
	private CodeDetailService codeDetailService;
	

	//목록조회 List
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ResponseEntity<List<CodeDetail>> list() throws Exception{
		
		log.info("list");
		
		return new ResponseEntity<List<CodeDetail>>(codeDetailService.list(), HttpStatus.OK);  
	}
	
	
	//상세조회 Read
	@RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.GET)
	public ResponseEntity<CodeDetail> read(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception {
		
		CodeDetail codeDetail = new CodeDetail();
		
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		return new ResponseEntity<CodeDetail>(codeDetailService.read(codeDetail), HttpStatus.OK) ;
	}
	

	//등록 Register
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<CodeDetail> register(@Validated @RequestBody CodeDetail codeDetail) throws Exception {
		log.info("register");
		
		codeDetailService.register(codeDetail);
		
		log.info("getGroupCode:"+codeDetail.getGroupCode());
		log.info("getCodeValue:"+codeDetail.getCodeValue());
		log.info("getCodeName:"+codeDetail.getCodeName());
		
		return new ResponseEntity<CodeDetail>(codeDetail, HttpStatus.OK);
	}
	
	//수정 Modify
	@RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Modify(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue, @Validated @RequestBody CodeDetail codeDetail) throws Exception{
	
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		codeDetailService.modify(codeDetail);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//삭제 Delete
	@RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> Delete(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception{
		
		CodeDetail codeDeTail = new CodeDetail();
		
		codeDeTail.setGroupCode(groupCode);
		codeDeTail.setCodeValue(codeValue);
		
		codeDetailService.remove(codeDeTail);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
