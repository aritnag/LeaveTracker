package com.vmware.projects.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectCategoryVO {

	private CategoryVO category;
	private List<ProjectVO> projects;

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public List<ProjectVO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectVO> projects) {
		this.projects = projects;
	}

}
