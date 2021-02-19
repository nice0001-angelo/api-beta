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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return "CodeGroup [groupCode=" + groupCode + ", groupName=" + groupName + ", useYn=" + useYn + ", regDate="
				+ regDate + ", updDate=" + updDate + "]";
	}
	
	
}
