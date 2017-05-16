package com.leaveservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LeaveDetailsVO {
	private LeaveVO leave;
	private PeopleLeaveRequestActionVO peopleLeave;
	public LeaveVO getLeave() {
		return leave;
	}
	public void setLeave(LeaveVO leave) {
		this.leave = leave;
	}
	public PeopleLeaveRequestActionVO getPeopleLeave() {
		return peopleLeave;
	}
	public void setPeopleLeave(PeopleLeaveRequestActionVO peopleLeave) {
		this.peopleLeave = peopleLeave;
	}
	

}
