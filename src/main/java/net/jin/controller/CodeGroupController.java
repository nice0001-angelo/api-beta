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
@RequestMapping("/codegroups")
public class CodeGroupController {
	
	@Autowired
	private CodeGroupService service;
	
	//상세조회
	@RequestMapping(value = "/{groupCode}", method = RequestMethod.GET)
	public ResponseEntity<CodeGroup> read(@PathVariable("groupCode") String groupCode) throws Exception{
		CodeGroup codeGroup = service.read(groupCode);
		
		return new ResponseEntity<>(codeGroup, HttpStatus.OK);
	}
	
	//목록조회
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<CodeGroup>> list() throws Exception{
		log.info("list");
		
		return new ResponseEntity<>(service.list(), HttpStatus.OK)
	}

}
