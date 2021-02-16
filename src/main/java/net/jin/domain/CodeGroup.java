/**
 * 
 */
package net.jin.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

/**
 * @author njh
 *
 */
@Getter
@Setter
@ToString
public class CodeGroup {
	
	private String groupCode;
	private String groupName;
	private String useYn;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date regDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updDate;

}
