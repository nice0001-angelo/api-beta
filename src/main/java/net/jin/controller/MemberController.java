/**
 * 
 */
package net.jin.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
import net.jin.domain.*;

/**
 * @author njh
 *
 */
@Log
@RestController
@RequestMapping(value = "/users")
public class MemberController {
	
	
	  @Autowired private MemberService memberservice;
	  
	 /* //비밀번호 암호 처리기 private PasswordEncoder passwordEncoder = new
	 * BCriptPasswordEncoder();
	 * 
	 * //등록
	 * 
	 * @RequestMapping(value = "", method = RequestMethod.POST) public
	 * RequestEntity<Member> register() throws Exception {
	 * 
	 * 
	 * 
	 * return new RequestEntity<Member>(member, HttpStatus.OK); }
	 */

	@RequestMapping(value ="", method = RequestMethod.GET)
	public ReponseEntity<List<member>> list() throws Exception{
		return new RequestEntity<List<member>>(memberservice.);
		
	}
}
