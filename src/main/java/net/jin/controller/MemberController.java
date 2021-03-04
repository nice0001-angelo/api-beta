/**
 * 
 */
package net.jin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;

/**
 * @author njh
 *
 */
@Log
@RestController
@RequestMapping(value = "/users")
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	//비밀번호 암호 처리기
	private PasswordEncoder passwordEncoder = new BCriptPasswordEncoder();

}
