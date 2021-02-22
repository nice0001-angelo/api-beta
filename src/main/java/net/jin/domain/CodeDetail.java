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
public class CodeDetail {

	private String groupCode;
	private String codeValue;
	private String codeName;
	private int sortSeq;
	private String useYn;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date regDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date updDate;
	
}
