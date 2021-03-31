/**
 * 
 */
package net.jin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
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
	
	
	@Autowired 
	private MemberService memberService;
	  
	  
	//비밀번호 암호 처리기
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
	 
	  
	//List all
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> list() throws Exception{
		System.out.println("MemberController list(): "+memberService.list());
		
		return new ResponseEntity<List<Member>>(memberService.list(), HttpStatus.OK);
		
	}
	
	//Read by userNo
	@RequestMapping(value ="/{userNo}", method = RequestMethod.GET)
	public ResponseEntity<Member> read(@PathVariable("userNo") int userNo) throws Exception{
		
		System.out.println("MemberController userNo: "+userNo);
		
		//Member member = memberService.read(userNo); 아래에  memberService.read(userNo)를 직접 넣어도 됨 
		
		return new ResponseEntity<Member>(memberService.read(userNo), HttpStatus.OK);
	}

	//insert all
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<Member> register(@Validated @RequestBody Member member) throws Exception {
		
		System.out.println("MemberController register member:"+member);
		
		//비밀번호 암호화
		String inputPassword = member.getUserPw();
		member.setUserPw(passwordEncoder.encode(inputPassword));

		//member객체를 memberService에 송부
		memberService.register(member);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK); 
		
	}
	
	//delete by userNo
	@RequestMapping(value="/{userNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("userNo") int userNo) throws Exception{
		System.out.println("MemberController delete by userNo: "+userNo);
		memberService.remove(userNo);
		
		return new ResponseEntity<String>("finally deleted~!",HttpStatus.NO_CONTENT); //왜 View에 finally deleted~! 이 안 찍히는지 확인필요
	}
	
	//update by userNo
	@RequestMapping(value = "/{userNo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modify(@PathVariable("userNo") int userNo, @Validated @RequestBody Member member) throws Exception{
		
		System.out.println("MemberController update userNo: "+userNo);
		System.out.println("MemberController update Member: "+member);
		
		member.setUserNo(userNo);
		
		memberService.modify(member);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
