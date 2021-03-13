/**
 * 
 */
package net.jin.controller;

import java.util.*;

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
	public ResponseEntity<List<Member>> list() throws Exception{
		return new ResponseEntity<List<Member>>(memberservice.list(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/{userNo}", method = RequestMethod.GET)
	public ResponseEntity<Member> read(@PathVariable("userNo") int userNo) throws Exception{
		
		System.out.println("MemberController userNo: "+userNo);
		
		Member member = memberservice.read(userNo);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	

}
