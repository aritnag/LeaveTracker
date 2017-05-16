package com.leaveservice.vo;

public class PeopleLeaveRequestActionVO {
	private Long peopleLeaveId;
	private String actionTaken;
	private People actionTakenByUser;
	private Long leaveId;
	private Long peopleId;
	private String duration;
	private String leaveStartDate;
	private String leaveEndDate;
	private String status;
	
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public String getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public People getActionTakenBy() {
		return actionTakenByUser;
	}
	public void setActionTakenBy(People actionTakenBy) {
		this.actionTakenByUser = actionTakenBy;
	}
	public Long getPeopleLeaveId() {
		return peopleLeaveId;
	}
	public void setPeopleLeaveId(Long peopleLeaveId) {
		this.peopleLeaveId = peopleLeaveId;
	}
}
