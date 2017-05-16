package com.leaveservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people_leave_request_action")
public class PeopleLeaveRequestAction {
	
	private Long peopleLeaveRequestAction;
	private Long peopleLeaveId;
	private Long peopleId;
	private String actionTaken;
	private Long actionTakenBy;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "people_leave_request_action_id")
	public Long getPeopleLeaveRequestAction() {
		return peopleLeaveRequestAction;
	}
	public void setPeopleLeaveRequestAction(Long peopleLeaveRequestAction) {
		this.peopleLeaveRequestAction = peopleLeaveRequestAction;
	}
	@Column(name = "people_leave_id")
	public Long getPeopleLeaveId() {
		return peopleLeaveId;
	}
	public void setPeopleLeaveId(Long peopleLeaveId) {
		this.peopleLeaveId = peopleLeaveId;
	}
	@Column(name = "people_id")
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	@Column(name = "action_taken")
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	@Column(name = "action_taken_by")
	public Long getActionTakenBy() {
		return actionTakenBy;
	}
	public void setActionTakenBy(Long actionTakenBy) {
		this.actionTakenBy = actionTakenBy;
	}	
}
