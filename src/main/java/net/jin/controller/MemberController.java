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
@RequestMapping(value = "/users")
public class MemberController {
	
	
	  @Autowired private MemberService memberService;
	  
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
	
	//List all
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> list() throws Exception{
		return new ResponseEntity<List<Member>>(memberService.list(), HttpStatus.OK);
		
	}
	
	//Read by userNo
	@RequestMapping(value ="/{userNo}", method = RequestMethod.GET)
	public ResponseEntity<Member> read(@PathVariable("userNo") int userNo) throws Exception{
		
		System.out.println("MemberController userNo: "+userNo);
		
		Member member = memberService.read(userNo);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	//insert all
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<Member> register(@Validated @RequestBody Member member) throws Exception {
		
		System.out.println("MemberController register member:"+member);
		
		memberService.register(member);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK); 
		
	}
	
	//delete by userNo
	@RequestMapping(value="/{userNo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("userNo") int userNo) throws Exception{
		System.out.println("MemberController delete by userNo: "+userNo);
		memberService.delete(userNo);
	}
	
	//update by userNo
	@RequestMapping(value = "/{userNo}", method = RequestMethod.PUT)
	public void update(@PathVariable("userNo") int userNo, @Validated @RequestBody Member member) throws Exception{
		System.out.println("MemberController update userNo: "+userNo);
		System.out.println("MemberController update Member: "+member);
		
		member.setUserNo(userNo);
		
		memberService.update(member);
	}
}
