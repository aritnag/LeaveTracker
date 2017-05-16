package com.leaveservice.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class User {


	private Long peopleId;
	private String firstName;
	private String lastName;
	private String email;
	private Role roles;
	private List<People> reportees;
	private People reporting;
	public Long getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role role) {
		this.roles = role;
	}

	public List<People> getReportees() {
		return reportees;
	}

	public void setReportees(List<People> reportees) {
		this.reportees = reportees;
	}

	public People getReporting() {
		return reporting;
	}

	public void setReporting(People reporting) {
		this.reporting = reporting;
	}



}
