/**
 * 
 */
package net.jin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
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
		
		return new ResponseEntity<CodeDetail>(codeDetailService.read(codeDetail)) ;
	}
	
	//목록조회
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ResponseEntity<List<CodeDetail>> list() throws Exception{
		
		return new ResponseEntity<List<CodeDetail>>(codeDetailService.list(), HttpStatus.OK);  
	}
	

}
