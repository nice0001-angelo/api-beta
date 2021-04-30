/**
 * 
 */
package net.jin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
import net.jin.common.util.*;
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
	 
	
	@Autowired
	private MessageSource messageSource;
	
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
	public ResponseEntity<Void> delete(@PathVariable("userNo") int userNo) throws Exception{
		System.out.println("MemberController delete by userNo: "+userNo);
		memberService.remove(userNo);
		
		//return new ResponseEntity<String>("finally deleted~!",HttpStatus.NO_CONTENT); //왜 View에 finally deleted~! 이 안 찍히는지 확인필요
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
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
	
	//회원테이블에 데이터가 없으면 최초관리자를 생성한다
	@RequestMapping(value = "/setup", method = RequestMethod.POST, produces= "text/plain;charset=UTF-8")
	public ResponseEntity<String> setupAdmin(@Validated @RequestBody Member member) throws Exception{
		
		log.info("setupAdmin member.getUserName: "+member.getUserName());
		log.info("setupAdmin memberService.countAll: "+memberService.countAll());
		
		//회원데이터 존재여부 확인
		if(memberService.countAll()==0)
		
		memberService.setupAdmin(member);
		
		return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
	}
	
	//회원정보를 가져온다
	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
	public ResponseEntity<Member> getMyinfo(@RequestHeader (name = "Authorization") String requestHeader) throws Exception{
		int userNo = AuthUtil.getUserNo(requestHeader);
		log.info("register userNo = "+ userNo);
		
		Member member = memberService.read(userNo);
		
		member.setUserPw("");
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	
}
