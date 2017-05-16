package com.vmware.projects.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "people_role_hierarchy")
public class PeopleRoleHierarchy {

	private Long peopleRoleHierarchyId;
	private Long peopleId;
	private Long roleId;
	private String isActive;
	private Long peopleIdReportedTo;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "people_role_hierarchy_id")
	public Long getPeopleRoleHierarchyId() {
		return peopleRoleHierarchyId;
	}
	public void setPeopleRoleHierarchyId(Long peopleRoleHierarchyId) {
		this.peopleRoleHierarchyId = peopleRoleHierarchyId;
	}
	@Column(name = "people_id")
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	@Column(name = "role_id")
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Column(name = "people_id_reported_to")
	public Long getPeopleIdReportedTo() {
		return peopleIdReportedTo;
	}
	public void setPeopleIdReportedTo(Long peopleIdReportedTo) {
		this.peopleIdReportedTo = peopleIdReportedTo;
	}

	

	

}
