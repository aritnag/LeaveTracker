package com.vmware.projects.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_member")
public class ProjectMember {

	private Long id;
	private People people;
	private Project project;

	public ProjectMember() {

	}

	public ProjectMember(Long projectId, Long peopleId) {

		this.people = new People();
		this.people.setPeopleId(peopleId);

		this.project = new Project();
		this.project.setProjectId(projectId);

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "people_id")
	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
