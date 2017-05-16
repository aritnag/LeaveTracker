package com.vmware.projects.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "project")
public class Project {

	private Long projectId;
	private ProjectCategory projectCategory;
	private String projectName;
	private String description;
	private List<ProjectMember> projectMembers;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "project_id")
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public ProjectCategory getProjectCategory() {
		return this.projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	@Column(name = "project_name")
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public List<ProjectMember> getProjectMembers() {
		return this.projectMembers;
	}

	public void setProjectMembers(List<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}

}
