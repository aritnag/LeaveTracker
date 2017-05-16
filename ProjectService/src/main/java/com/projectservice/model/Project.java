package com.projectservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTS")
public class Project {

private Long projectId;
private String projectName;
private String projectDetails;
private String isActive;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "project_id")
public Long getProjectId() {
	return projectId;
}
public void setProjectId(Long projectId) {
	this.projectId = projectId;
}

@Column(name = "project_name")
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
@Column(name = "project_details")
public String getProjectDetails() {
	return projectDetails;
}
public void setProjectDetails(String projectDetails) {
	this.projectDetails = projectDetails;
}
@Column(name = "is_active")
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
 

}
