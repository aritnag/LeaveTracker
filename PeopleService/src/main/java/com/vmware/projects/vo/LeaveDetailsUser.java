package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LeaveDetailsUser {

	private User user;
	private List<LeaveDetailsVO> leaveDetails;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<LeaveDetailsVO> getLeaveDetails() {
		return leaveDetails;
	}
	public void setLeaveDetails(List<LeaveDetailsVO> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}
	
}
