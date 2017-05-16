package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class UserDetailsByLeaves {

	private List<PeopleLeaveDetailsVO> peopleLeaveDetails;
	private LeaveVO leaveDetails;
	public List<PeopleLeaveDetailsVO> getPeopleLeaveDetails() {
		return peopleLeaveDetails;
	}
	public void setPeopleLeaveDetails(List<PeopleLeaveDetailsVO> peopleLeaveDetails) {
		this.peopleLeaveDetails = peopleLeaveDetails;
	}
	public LeaveVO getLeaveDetails() {
		return leaveDetails;
	}
	public void setLeaveDetails(LeaveVO leaveDetails) {
		this.leaveDetails = leaveDetails;
	}
	
}
