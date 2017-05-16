package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectMemberVO {

	private ProjectVO project;
	private List<PeopleVO> teamMembers;

	public ProjectVO getProject() {
		return project;
	}

	public void setProject(ProjectVO project) {
		this.project = project;
	}

	public List<PeopleVO> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<PeopleVO> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
