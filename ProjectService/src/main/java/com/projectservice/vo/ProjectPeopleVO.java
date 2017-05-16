package com.projectservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectPeopleVO {
	private Long projectPeopleId;
	private Long peopleId;
	private Long projectId;
	private Long projectLeadId;
	public Long getProjectPeopleId() {
		return projectPeopleId;
	}
	public void setProjectPeopleId(Long projectPeopleId) {
		this.projectPeopleId = projectPeopleId;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getProjectLeadId() {
		return projectLeadId;
	}
	public void setProjectLeadId(Long projectLeadId) {
		this.projectLeadId = projectLeadId;
	}
}
