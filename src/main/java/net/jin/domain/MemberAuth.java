/**
 * 
 */
package net.jin.domain;

import javax.validation.constraints.*;

import lombok.*;

/**
 * @author njh
 *
 */

@Getter
@Setter
@ToString
public class MemberAuth {
	
	@NotBlank
	private int userNo;
	
	@NotBlank
	private String auto;

}
