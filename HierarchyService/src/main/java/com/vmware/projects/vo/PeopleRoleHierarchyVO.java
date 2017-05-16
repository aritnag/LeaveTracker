package com.vmware.projects.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PeopleRoleHierarchyVO {

	private Long peopleRoleHierarchyId;
	private Long peopleId;
	private Long roleId;
	private String isActive;
	private Long peopleIdReportedTo;
	public Long getPeopleRoleHierarchyId() {
		return peopleRoleHierarchyId;
	}
	public void setPeopleRoleHierarchyId(Long peopleRoleHierarchyId) {
		this.peopleRoleHierarchyId = peopleRoleHierarchyId;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Long getPeopleIdReportedTo() {
		return peopleIdReportedTo;
	}
	public void setPeopleIdReportedTo(Long peopleIdReportedTo) {
		this.peopleIdReportedTo = peopleIdReportedTo;
	}
}
