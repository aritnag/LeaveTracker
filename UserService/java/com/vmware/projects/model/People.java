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
@Table(name = "people")
public class People {

	private Long peopleId;
	private String firstName;
	private String lastName;
	private String email;
	private List<ProjectMember> projectMembers;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "people_id")
	public Long getPeopleId() {
		return this.peopleId;
	}

	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "people")
	public List<ProjectMember> getProjectMembers() {
		return this.projectMembers;
	}

	public void setProjectMembers(List<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}

}
