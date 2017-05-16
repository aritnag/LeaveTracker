package com.projectservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectDetailsVO {

	private ProjectVO project;
	private ProjectPeopleVO projectPeople;
	public ProjectVO getProject() {
		return project;
	}
	public void setProject(ProjectVO project) {
		this.project = project;
	}
	public ProjectPeopleVO getProjectPeople() {
		return projectPeople;
	}
	public void setProjectPeople(ProjectPeopleVO projectPeople) {
		this.projectPeople = projectPeople;
	}
}
