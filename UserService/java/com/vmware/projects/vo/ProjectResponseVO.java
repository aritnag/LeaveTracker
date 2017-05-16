package com.vmware.projects.vo;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectResponseVO {

	private Long projectId;
	private String projectName;
	private String description;
	private List<PeopleVO> teamMembers;

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PeopleVO> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<PeopleVO> teamMembers) {
		this.teamMembers = teamMembers;
	}
}
