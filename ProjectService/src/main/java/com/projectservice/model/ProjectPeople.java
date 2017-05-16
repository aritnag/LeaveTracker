package com.projectservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_PEOPLE")
public class ProjectPeople {
	private Long projectPeopleId;
	private Long peopleId;
	private Long projectId;
	private Long projectLeadId;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "project_people_id")
	public Long getProjectPeopleId() {
		return projectPeopleId;
	}
	public void setProjectPeopleId(Long projectPeopleId) {
		this.projectPeopleId = projectPeopleId;
	}
	@Column(name = "people_id")
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	@Column(name = "project_id")
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	@Column(name = "project_lead")
	public Long getProjectLeadId() {
		return projectLeadId;
	}
	public void setProjectLeadId(Long projectLeadId) {
		this.projectLeadId = projectLeadId;
	}
	

}
