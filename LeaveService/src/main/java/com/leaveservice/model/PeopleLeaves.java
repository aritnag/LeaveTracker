package com.leaveservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people_leaves")
public class PeopleLeaves {
	
	private Long peopleLeaveId;
	private Long leaveId;
	private Long peopleId;
	private String duration;
	private String leaveStartDate;
	private String leaveEndDate;
	private String status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "people_leave_id")
	public Long getPeopleLeaveId() {
		return peopleLeaveId;
	}
	public void setPeopleLeaveId(Long peopleLeaveId) {
		this.peopleLeaveId = peopleLeaveId;
	}
	@Column(name = "leave_id")
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	@Column(name = "people_id")
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	@Column(name = "duration")
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Column(name = "leave_start_date")
	public String getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	@Column(name = "leave_end_date")
	public String getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
