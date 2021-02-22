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
	
	//상세조회
	@RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.GET)
	public ResponseEntity<CodeDetail> read(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeValue) throws Exception {
		
		CodeDetail codeDetail = new CodeDetail();
		
		codeDetail.setGroupCode(groupCode);
		codeDetail.setCodeValue(codeValue);
		
		return new ResponseEntity<CodeDetail>(codeDetailService.read(codeDetail), HttpStatus.OK) ;
	}
	
	//목록조회
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ResponseEntity<List<CodeDetail>> list() throws Exception{
		
		log.info("list");
		
		return new ResponseEntity<List<CodeDetail>>(codeDetailService.list(), HttpStatus.OK);  
	}
	
	//등록
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<CodeDetail> register(@Validated @RequestBody CodeDetail codeDetail) throws Exception {
		log.info("register");
		
		codeDetailService.register(codeDetail);
		
		log.info("getGroupCode:"+CodeDetail.getGroupCode());
		log.info("getCodeValue:"+CodeDetail.getCodevalue());
		
		return ResponseEntity<CodeDetail>(CodeDetail, HttpStatus.OK);
	}
	
	//수정
	@RequestMapping(value = "/{groupCode}/{codeValue}", method = RequestMethod.PUT)
	public void Modify(@PathVariable("groupCode") String groupCode, @PathVariable("codeValue") String codeGroup, @Validated @RequestBody CodeDetail codeDetail) {
		
	}
	
	
	 
	
)

}
