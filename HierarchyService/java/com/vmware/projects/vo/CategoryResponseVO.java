package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CategoryResponseVO {

	private Long categoryId;
	private String name;
	private String description;
	private List<ProjectResponseVO> projects;

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectResponseVO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectResponseVO> projects) {
		this.projects = projects;
	}
}
