/**
 * 
 */
package net.jin.common.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
import net.jin.common.domain.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */
@Log
@RestController
@RequestMapping(value = "/codes")
public class CodeController {
	
	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value ="/codeGroup", method = RequestMethod.GET)
	public ResponseEntity<List<CodeLabelValue>> codeGroupList() throws Exception{
		log.info("codeGroupList");
		
		return new ResponseEntity<List<CodeLabelValue>>(codeService.getCodeGroupList(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public ResponseEntity<List<CodeLabelValue>> jobList() throws Exception{
		
		String groupCode = "A01";
		
		return new ResponseEntity<List<CodeLabelValue>>(codeService.getCodeGroupList(groupCode),HttpStatus.OK);
	}

}
