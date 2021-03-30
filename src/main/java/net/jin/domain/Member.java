/**
 * 
 */
package net.jin.domain;

import java.util.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

/**
 * @author njh
 *
 */
@Getter
@Setter
@ToString
public class Member {

	private int userNo;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String userPw;
	
	@NotBlank
	private String userName;
	
	private String job;
	
	private int coin;
	
	private boolean enalbed;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date regDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updDate;
	
	private List<MemberAuth> memberAuthList;
}
