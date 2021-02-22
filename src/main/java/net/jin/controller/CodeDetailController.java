/**
 * 
 */
package net.jin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
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
	
	@RequestMapping(value="/{groupCode}/{codeValue}", method=RequestMethod.GET)

}
