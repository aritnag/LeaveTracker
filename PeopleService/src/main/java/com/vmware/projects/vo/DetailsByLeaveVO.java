package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DetailsByLeaveVO {
	private LeaveVO leave;
	private List<PeopleLeaveRequestActionVO> peopleLeave;
	public LeaveVO getLeave() {
		return leave;
	}
	public void setLeave(LeaveVO leave) {
		this.leave = leave;
	}
	public List<PeopleLeaveRequestActionVO> getPeopleLeave() {
		return peopleLeave;
	}
	public void setPeopleLeave(List<PeopleLeaveRequestActionVO> peopleLeave) {
		this.peopleLeave = peopleLeave;
	}
}
