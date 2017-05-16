package com.leaveservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LEAVES")
public class Leave {
private Long leaveId;
private String type;
private String isActive;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "leave_id")
public Long getLeaveId() {
	return leaveId;
}
public void setLeaveId(Long leaveId) {
	this.leaveId = leaveId;
}
@Column(name = "leave_type")
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Column(name = "is_active")
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}


}
