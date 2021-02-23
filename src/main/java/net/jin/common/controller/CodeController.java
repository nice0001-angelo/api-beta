/**
 * 
 */
package net.jin.common.controller;

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
@RequestMapping(value = "/codes")
public class CodeController {
	
	@Autowired
	private CodeService codeService;
	
	

}
